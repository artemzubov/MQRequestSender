package com.trgr.dockets.RequestSender.controller;

import com.trgr.dockets.RequestSender.domain.MqRequestDto;
import com.trgr.dockets.RequestSender.service.MqRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/mqrequest")
public class MqRequestController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private MqRequestService mqRequestService;

    @Value("${ibm.mq.queueName}")
    private String queueName;

    @PostMapping("/prepare")
    public Map<String, String> prepare(@RequestBody MqRequestDto mqRequestDto) {
        Map<String, String> request = new HashMap<>();
        request.put("mqRequest", mqRequestService.buildRequest(mqRequestDto));
        return request;
    }

    @PostMapping("/send")
    public void send(@RequestBody String request) {
        jmsTemplate.convertAndSend(queueName, request);
    }
}
