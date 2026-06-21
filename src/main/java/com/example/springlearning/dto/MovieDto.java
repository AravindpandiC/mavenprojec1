package com.example.springlearning.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * DTO for {@link com.example.springlearning.entity.Movie}
 */
public class MovieDto implements Serializable {
    private final String name;
    private final LocalDate releaseDate;

    public MovieDto(String name, LocalDate releaseDate) {
        this.name = name;
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieDto entity = (MovieDto) o;
        return Objects.equals(this.name, entity.name) &&
                Objects.equals(this.releaseDate, entity.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, releaseDate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "name = " + name + ", " +
                "releaseDate = " + releaseDate + ")";
    }
}