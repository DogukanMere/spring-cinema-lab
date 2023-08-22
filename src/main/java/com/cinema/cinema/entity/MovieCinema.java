package com.cinema.cinema.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "movie_cinema")
public class MovieCinema extends BaseEntity {

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cinema cinema;

    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;

    @OneToMany(mappedBy = "movieCinema")
    private List<Ticket> ticket;

    public MovieCinema(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

}
