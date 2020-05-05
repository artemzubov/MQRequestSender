package com.trgr.dockets.RequestSender.controller;

import com.trgr.dockets.RequestSender.domain.Vendor;
import com.trgr.dockets.RequestSender.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vendor")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @GetMapping("/findByCourtId/{courtId}")
    public List<Vendor> findByCourtId(@PathVariable("courtId") Long courtId) {
        return vendorService.findByCourtId(courtId);
    }
}
