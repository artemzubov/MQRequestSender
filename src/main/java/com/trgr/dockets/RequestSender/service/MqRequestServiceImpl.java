package com.trgr.dockets.RequestSender.service;

import com.trgr.dockets.RequestSender.domain.MqRequestDto;
import com.trgr.dockets.RequestSender.repo.CourtRepo;
import com.trgr.dockets.RequestSender.repo.ProductRepo;
import com.trgr.dockets.RequestSender.util.DateTimeParser;
import com.trgr.dockets.RequestSender.util.ServerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Service
public class MqRequestServiceImpl implements MqRequestService {

    @Autowired
    private CourtRepo courtRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ServerHelper serverHelper;

    @Autowired
    private DateTimeParser dateTimeParser;

    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("yyyyMMdd.HHmmss");

    public String buildRequest(MqRequestDto mqRequestDto) {
        StringBuilder xmlMqRequest = new StringBuilder();
        String serverDateTimeAsStringLinuxFormatted = serverHelper.getServerDateLinuxFormatted();
        LocalDateTime serverDateTime = dateTimeParser.parseDateTime(serverDateTimeAsStringLinuxFormatted);
        xmlMqRequest.append("<preprocessor_request>")
                .append("<courtName>")
                .append(courtRepo.findById(mqRequestDto.getCourtId()).get().getCourtCluster())
                .append("</courtName>")

                .append("<sourceFile>")
                .append(mqRequestDto.getSourceFile())
                .append("</sourceFile>")

                .append("<requestId>")
                .append(createRequestId())
                .append("</requestId>")

                .append("<startTime>")
                .append(serverDateTime.format(FORMAT))
                .append("</startTime>")

                .append("<endTime>")
                .append(serverDateTime.plusHours(1).format(FORMAT))
                .append("</endTime>")

                .append("<workflowType>")
                .append(mqRequestDto.getWorkflowType())
                .append("</workflowType>")

                .append("<requestInitiatorType>")
                .append(mqRequestDto.getRequestInitiatorType())
                .append("</requestInitiatorType>")

                .append("<requestType>")
                .append(mqRequestDto.getRequestType())
                .append("</requestType>")

                .append("<product>")
                .append(productRepo.findById(mqRequestDto.getProductId()).get().getDisplayName())
                .append("</product>")

                .append("<client>")
                .append("Data Capture")
                .append("</client>")

                .append("<requestName>")
                .append(mqRequestDto.getRequestName())
                .append("</requestName>")

                .append("<vendorId>")
                .append(mqRequestDto.getVendorId())
                .append("</vendorId>");

        if (mqRequestDto.isFifoOverride()) {
            xmlMqRequest
                    .append("<FIFOOverride>")
                    .append("True")
                    .append("</FIFOOverride>");
        }

        if (mqRequestDto.isAqTimeOverride()) {
            xmlMqRequest
                    .append("<aqTimeOverride>")
                    .append("Y")
                    .append("</aqTimeOverride>");
        }

        return xmlMqRequest.append("</preprocessor_request>").toString();
    }

    private String createRequestId() {
        StringBuilder uuid = new StringBuilder();
        new Random().ints(32, 0, 10).forEach(uuid::append);
        return "I" + uuid.toString();
    }
}
