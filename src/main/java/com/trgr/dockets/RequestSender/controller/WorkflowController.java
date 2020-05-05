package com.trgr.dockets.RequestSender.controller;

import com.trgr.dockets.RequestSender.service.WorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workflow")
public class WorkflowController {

    @Autowired
    private WorkflowService workflowService;

    @GetMapping("/findByProductId/{productId}")
    List<String> findByProductId(@PathVariable("productId") Long productId) {
        return workflowService.getByProductId(productId);
    }
}
