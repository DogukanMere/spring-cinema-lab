package com.cinema.cinema.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user_account")
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    private String password;
    private String username;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_details_id")
    private AccountDetails accountdetails;

    @OneToMany(mappedBy = "userAccount")
    private List<Ticket> ticket;

    public UserAccount(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }
}
