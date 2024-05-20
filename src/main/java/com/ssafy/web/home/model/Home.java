package com.ssafy.web.home.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Entity
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String price;
    private String constructionYear;
    private String legalDong;
    private String aptName;
    private String exclusiveArea;
    private String addressNumber;
    private String floor;

    private Double lat;
    private Double lon;

    public Home(){}

    public Home(String price, String constructionYear, String legalDong, String aptName, String exclusiveArea, String addressNumber, String floor, Double lat, Double lon) {
        this.price = price;
        this.constructionYear = constructionYear;
        this.legalDong = legalDong;
        this.aptName = aptName;
        this.exclusiveArea = exclusiveArea;
        this.addressNumber = addressNumber;
        this.floor = floor;
        this.lat = lat;
        this.lon = lon;
    }

    public String getPrice() {
        return price;
    }

    public String getConstructionYear() {
        return constructionYear;
    }

    public String getLegalDong() {
        return legalDong;
    }

    public String getAptName() {
        return aptName;
    }

    public String getExclusiveArea() {
        return exclusiveArea;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public String getFloor() {
        return floor;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLon() {
        return lon;
    }
}
