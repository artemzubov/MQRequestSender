package com.trgr.dockets.RequestSender.service;

import com.trgr.dockets.RequestSender.domain.Product;
import com.trgr.dockets.RequestSender.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> findByOrderByIdAsc() {
        return productRepo.findByOrderByIdAsc();
    }
}
