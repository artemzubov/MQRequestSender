package com.trgr.dockets.RequestSender.repo;

import com.trgr.dockets.RequestSender.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VendorRepo extends JpaRepository<Vendor, Long> {

    @Query(nativeQuery = true,
            value = "select * from dockets_pub.court court " +
                    "left join dockets_pub.vendor_court v_c on court.court_id = v_c.court_id " +
                    "left join dockets_pub.vendor vendor on v_c.vendor_id = vendor.vendor_id " +
                    "where court.court_id = :courtId ")
    List<Vendor> findByCourtId(Long courtId);
}
