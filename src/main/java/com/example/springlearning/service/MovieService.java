package com.example.springlearning.service;

import com.example.springlearning.dto.MovieDto;
import com.example.springlearning.entity.Movie;
import com.example.springlearning.entity.Show;
import com.example.springlearning.repository.ShowRepository;
import com.example.springlearning.repository.MovieRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    ShowRepository showRepository;

    @PersistenceContext
    EntityManager entityManager;

    public List<MovieDto> getMovies() throws InterruptedException {

//        List<MovieDto> movieDtos = jdbcTemplate.query("select * from bookmyshowfinal.movies",
//                (rs, rowNum) -> new MovieDto(rs.getString("name")
//                        ,rs.getDate("release_date").toLocalDate()));

        List<MovieDto> movieDtos = movieRepository.findAll().stream()
                .map(movie -> new MovieDto(movie.getName(), movie.getReleaseDate()))
                .toList();

        Movie movie1 = movieRepository.findById(1).orElse(null);
        Movie movie2 = movieRepository.findById(1).orElse(null);
        System.out.println(movie1==movie2);

        Show show1 = showRepository.findById(1).orElse(null);
        Show show2 = showRepository.findById(1).orElse(null);





        return movieDtos;
    }

    public void sleep() {
        jdbcTemplate.query("select sleep(10)", (rs)->null);

    }


}
