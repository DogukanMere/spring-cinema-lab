package com.cinema.cinema.entity;

import com.cinema.cinema.enums.State;
import com.cinema.cinema.enums.Type;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private BigDecimal price;

    @Enumerated(value = EnumType.STRING)
    private Type type;
    @Enumerated(value = EnumType.STRING)
    private State state;

    @Column(name = "release_date")
    @DateTimeFormat(style = "DATE")
    private LocalDate releaseDate;

    private String duration;
    private String summary;

    @OneToMany(mappedBy = "movie")
    private List<MovieCinema> movieCinema;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "movie_genre_rel", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres;

    public Movie(String name, BigDecimal price, Type type, State state, LocalDate releaseDate, String duration, String summary) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.state = state;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.summary = summary;
    }
}
