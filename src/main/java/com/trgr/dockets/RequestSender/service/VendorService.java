package com.trgr.dockets.RequestSender.service;

import com.trgr.dockets.RequestSender.domain.Vendor;

import java.util.List;

public interface VendorService {

    List<Vendor> findByCourtId(Long courtId);
}
