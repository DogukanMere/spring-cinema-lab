package com.cinema.cinema.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date_time")
    @DateTimeFormat(style = "DATE")
    private LocalDate dateTime;

    @Column(name = "seat_number")
    private String seatNumber;

    @Column(name = "row_number")
    private String rowNumber;

    @ManyToOne
    private UserAccount userAccount;

    @ManyToOne
    private MovieCinema movieCinema;

    public Ticket(LocalDate dateTime, String rowNumber) {
        this.dateTime = dateTime;
        this.rowNumber = rowNumber;
    }
}
