package dev.gladkowski.mdb.data.repository.movies.converter;


import java.util.ArrayList;
import java.util.List;

import dev.gladkowski.mdb.entity.movies.data.MovieResponse;
import dev.gladkowski.mdb.entity.movies.data.MovieResponseByPage;
import dev.gladkowski.mdb.entity.movies.domain.Movie;


/**
 * Implementation of MovieListResponseConverter
 */
public class MovieListResponseConverterImpl implements MovieListResponseConverter {

    @Override
    public List<Movie> apply(MovieResponseByPage responseByPage) throws Exception {
        List<MovieResponse> responseList = responseByPage.getResults();
        List<Movie> moviesList = new ArrayList<>();

        for (MovieResponse response : responseList) {
            moviesList.add(new Movie(response.getId(),
                    response.getTitle(),
                    response.getPosterPath()));
        }

        return moviesList;
    }
}
