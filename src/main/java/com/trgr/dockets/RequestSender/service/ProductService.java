package com.trgr.dockets.RequestSender.service;

import com.trgr.dockets.RequestSender.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> findByOrderByIdAsc();
}
