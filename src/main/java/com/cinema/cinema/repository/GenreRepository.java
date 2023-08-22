package com.cinema.cinema.repository;

import com.cinema.cinema.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
1