package com.trgr.dockets.RequestSender.service;

import com.trgr.dockets.RequestSender.domain.MqRequestDto;

public interface MqRequestService {

    String buildRequest(MqRequestDto mqRequestDto);
}
