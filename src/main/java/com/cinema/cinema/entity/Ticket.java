package com.cinema.cinema.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private int id;

    @Column(name = "date_time")
    @DateTimeFormat(style = "DATE")
    private LocalDate dateTime;

    @Column(name = "row_number")
    private String rowNumber;

    @ManyToOne
    private UserAccount userAccount;

    public Ticket(LocalDate dateTime, String rowNumber) {
        this.dateTime = dateTime;
        this.rowNumber = rowNumber;
    }
}
