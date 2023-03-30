package com.example.lab3.dao;

import com.example.lab3.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Movie> movieRowMapper = (rs, rowNum) -> new Movie(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getInt("year"),
            rs.getDouble("rank")
    );

    public List<Movie> getAllMovies() {
        String sql = "SELECT * FROM movies";
        return jdbcTemplate.query(sql, movieRowMapper);
    }

    public int updateMovie(int id, Movie movie) {
        String sql = "UPDATE movies SET \"NAME\" = ?, \"year\" = ?, \"RANK\" = ? WHERE \"ID\" = ?";
        return jdbcTemplate.update(sql, movie.getName(), movie.getYear(), movie.getRank(), id);
    }

    public int deleteMovie(int id) {
        String sql = "DELETE FROM movies WHERE \"ID\" = ?";
        return jdbcTemplate.update(sql, id);
    }
}
