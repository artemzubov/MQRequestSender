package com.trgr.dockets.RequestSender.service;

import com.trgr.dockets.RequestSender.domain.Court;

import java.util.List;

public interface CourtService {

    List<Court> findByProductIdOrderByDisplayNameAsc(Long productId);

}
