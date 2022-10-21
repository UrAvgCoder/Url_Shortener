package com.example.tinyurlclone.model.misc;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MetaData {
    @Id
    @GeneratedValue
    private long id;
    private String country;
    private String ipAddress;
    private String userAgent;

    public void setCountry(String country) {
        this.country = country;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public MetaData() {
    }
}
