package com.trgr.dockets.RequestSender.service;

import com.trgr.dockets.RequestSender.domain.Product;
import com.trgr.dockets.RequestSender.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkflowServiceImpl implements WorkflowService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<String> getByProductId(Long productId) {
        Optional<Product> product = productRepo.findById(productId);
        List<String> workflows = new ArrayList<>();

        product.ifPresent(prod -> {
            switch (prod.getDisplayName()) {
                case "STATE":
                    workflows.add("STATEDOCKET-BIGDOCKET-RPX-LINKED");
                    workflows.add("STATEDOCKET-BIGDOCKET-RPX-LINKED-PRT");
                    workflows.add("STATEDOCKET-BIGDOCKET-UNLINKED");
                    workflows.add("STATEDOCKET-BIGDOCKET-UNLINKED-PRT");
                    break;
                case "FEDERAL":
                    workflows.add("FEDDOCKET-RPX-LINKED");
                    workflows.add("FEDDOCKET-RPX-LINKED-PRT");
                    workflows.add("FEDDOCKET-UNLINKED");
                    workflows.add("FEDDOCKET-UNLINKED-PRT");
                    break;
                case "JPML":
                    workflows.add("FEDJPMLDOCKET-RPX-LINKED");
                    workflows.add("FEDJPMLDOCKET-RPX-LINKED-PRT");
                    workflows.add("FEDJPMLDOCKET-UNLINKED");
                    workflows.add("FEDJPMLDOCKET-UNLINKED-PRT");
                    break;
                case "DCT":
                    workflows.add("DCT-RPX-LINKED");
                    workflows.add("DCT-RPX-LINKED-PRT");
                    workflows.add("DCT-UNLINKED");
                    workflows.add("DCT-UNLINKED-PRT");
                    break;
            }
        });

        if (workflows.isEmpty()) {
            workflows.add("Unknown workflow");
        }

        return workflows;
    }
}
