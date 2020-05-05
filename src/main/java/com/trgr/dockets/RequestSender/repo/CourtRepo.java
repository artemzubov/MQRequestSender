package com.trgr.dockets.RequestSender.repo;

import com.trgr.dockets.RequestSender.domain.Court;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourtRepo extends JpaRepository<Court, Long> {

    List<Court> findByProductIdOrderByDisplayNameAsc(Long productId);

}
