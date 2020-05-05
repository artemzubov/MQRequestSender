package com.trgr.dockets.RequestSender.domain;

import javax.persistence.*;

@Entity
@Table(name="VENDOR",schema="DOCKETS_PUB")
public class Vendor {

    @Id
    @Column(name="VENDOR_ID")
    private Long id;

    @Column(name="VENDOR_DESCRIPTION")
    private String displayName;

    public Vendor(){
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
