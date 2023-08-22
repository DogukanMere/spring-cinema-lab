package com.cinema.cinema.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "movie_cinema")
public class MovieCinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @DateTimeFormat(style = "DATE")
    private LocalDate dateTime;

    @ManyToOne
    private Cinema cinema;

    @ManyToOne
    private Movie movie;

    @OneToMany(mappedBy = "movieCinema")
    private List<Ticket> ticket;

    public MovieCinema(LocalDate dateTime) {
        this.dateTime = dateTime;
    }

}
