package com.cinema.cinema.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name = "genre")
public class Genre extends BaseEntity {

    private String name;

    @ManyToMany(mappedBy = "genres")
    private List<Movie> movies;

    public Genre(String name) {
        this.name = name;
    }
}
