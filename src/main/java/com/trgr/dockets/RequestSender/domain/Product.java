package com.trgr.dockets.RequestSender.domain;

import javax.persistence.*;

@Entity
@Table(name="PRODUCT",schema="DOCKETS_PUB")
public class Product {

    @Id
    @Column(name="PRODUCT_ID")
    private Long id;

    @Column(name="DISPLAY_NAME")
    private String displayName;

    public Product(){
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

