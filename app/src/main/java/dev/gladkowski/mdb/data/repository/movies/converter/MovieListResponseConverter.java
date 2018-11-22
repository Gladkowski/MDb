package dev.gladkowski.mdb.data.repository.movies.converter;


import java.util.List;

import dev.gladkowski.mdb.entity.movies.data.MovieResponseByPage;
import dev.gladkowski.mdb.entity.movies.domain.Movie;
import io.reactivex.functions.Function;

/**
 * Converts MovieResponseByPage object into List<Movie> object
 */
public interface MovieListResponseConverter extends Function <MovieResponseByPage, List<Movie>> {
}
