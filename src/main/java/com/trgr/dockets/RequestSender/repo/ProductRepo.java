package com.trgr.dockets.RequestSender.repo;

import com.trgr.dockets.RequestSender.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {

    List<Product> findByOrderByIdAsc();
}
