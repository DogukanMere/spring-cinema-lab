package com.cinema.cinema.entity;

import com.cinema.cinema.enums.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "account_details")
public class AccountDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String address;
    private String country;
    private String city;
    private String state;
    private String age;
    private String postalCode;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @OneToOne(mappedBy="accountdetails")
    private UserAccount useraccount;

    public AccountDetails(String name, String address, String country, String city, String state, String age, String postalCode, Role role) {
        this.name = name;
        this.address = address;
        this.country = country;
        this.city = city;
        this.state = state;
        this.age = age;
        this.postalCode = postalCode;
        this.role = role;
    }
}
