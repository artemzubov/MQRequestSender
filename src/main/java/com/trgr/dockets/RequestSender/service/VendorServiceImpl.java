package com.trgr.dockets.RequestSender.service;

import com.trgr.dockets.RequestSender.domain.Vendor;
import com.trgr.dockets.RequestSender.repo.VendorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorRepo vendorRepo;

    @Override
    public List<Vendor> findByCourtId(Long courtId) {
        return vendorRepo.findByCourtId(courtId);
    }
}
