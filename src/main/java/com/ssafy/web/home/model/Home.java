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

    private String title;
    private String description;
    private String price;
    private Long lat;
    private Long lon;

    public Home(Long id, String title, String description, String price, Long lat, Long lon) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.lat = lat;
        this.lon = lon;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public Long getLat() {
        return lat;
    }

    public Long getLon() {
        return lon;
    }
}
