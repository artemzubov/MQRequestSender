package com.trgr.dockets.RequestSender.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COURT",schema="DOCKETS_PUB")
public class Court {

    @Id
    @Column(name="COURT_ID")
    private Long id;

    @Column(name="COURT_NORM")
    private String displayName;

    @Column(name = "COURT_CLUSTER")
    private String courtCluster;

    @Column(name = "PRODUCT_ID")
    private Long productId;

    public Court(){
    }

    public String getCourtCluster() {
        return courtCluster;
    }

    public void setCourtCluster(String courtCluster) {
        this.courtCluster = courtCluster;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}

