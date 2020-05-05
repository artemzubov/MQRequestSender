package com.trgr.dockets.RequestSender.service;

import java.util.List;

public interface WorkflowService {

    List<String> getByProductId(Long productId);
}
