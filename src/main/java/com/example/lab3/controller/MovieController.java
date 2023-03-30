package com.example.lab3.controller;

import com.example.lab3.dao.MovieDao;
import com.example.lab3.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    @Autowired
    private MovieDao movieDao;

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieDao.getAllMovies();
    }

    @PutMapping("/{id}")
    public int updateMovie(@PathVariable int id, @RequestBody Movie movie) {
        return movieDao.updateMovie(id, movie);
    }

    @DeleteMapping("/{id}")
    public int deleteMovie(@PathVariable int id) {
        return movieDao.deleteMovie(id);
    }
}
