package com.cinema.cinema.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "location")
public class Location extends BaseEntity {

    private String name;
    private String latitude;
    private String longitude;
    private String country;
    private String city;
    private String state;

    @Column(name = "postal_code")
    private String postalCode;
    private String address;

    @OneToMany(mappedBy = "location")
    private List<Cinema> cinema;

    public Location(String name, String latitude, String longitude, String country, String city, String state, String postalCode, String address) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.country = country;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.address = address;
    }
}
