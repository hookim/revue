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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getConstructionYear() {
        return constructionYear;
    }

    public void setConstructionYear(String constructionYear) {
        this.constructionYear = constructionYear;
    }

    public String getLegalDong() {
        return legalDong;
    }

    public void setLegalDong(String legalDong) {
        this.legalDong = legalDong;
    }

    public String getAptName() {
        return aptName;
    }

    public void setAptName(String aptName) {
        this.aptName = aptName;
    }

    public String getExclusiveArea() {
        return exclusiveArea;
    }

    public void setExclusiveArea(String exclusiveArea) {
        this.exclusiveArea = exclusiveArea;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Home{" +
                "price='" + price + '\'' +
                ", constructionYear='" + constructionYear + '\'' +
                ", legalDong='" + legalDong + '\'' +
                ", aptName='" + aptName + '\'' +
                ", exclusiveArea='" + exclusiveArea + '\'' +
                ", addressNumber='" + addressNumber + '\'' +
                ", floor='" + floor + '\'' +
                '}';
    }
}
