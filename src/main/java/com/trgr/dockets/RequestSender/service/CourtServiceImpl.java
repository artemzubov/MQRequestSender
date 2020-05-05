package com.trgr.dockets.RequestSender.service;

import com.trgr.dockets.RequestSender.domain.Court;
import com.trgr.dockets.RequestSender.repo.CourtRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourtServiceImpl implements CourtService {

    @Autowired
    private CourtRepo courtRepo;

    @Override
    public List<Court> findByProductIdOrderByDisplayNameAsc(Long productId) {
        return courtRepo.findByProductIdOrderByDisplayNameAsc(productId);
    }
}
