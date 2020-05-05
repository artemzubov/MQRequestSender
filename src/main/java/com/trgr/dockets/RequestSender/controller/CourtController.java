package com.trgr.dockets.RequestSender.controller;

import com.trgr.dockets.RequestSender.domain.Court;
import com.trgr.dockets.RequestSender.service.CourtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/court")
public class CourtController {

    @Autowired
    private CourtService courtService;

    @GetMapping("/findByProductId/{productId}")
    List<Court> findByProductIdOrderByDisplayNameAsc(@PathVariable("productId") Long productId) {
        return courtService.findByProductIdOrderByDisplayNameAsc(productId);
    }
}
