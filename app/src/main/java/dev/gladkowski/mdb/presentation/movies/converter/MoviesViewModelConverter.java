package dev.gladkowski.mdb.presentation.movies.converter;

import java.util.List;

import dev.gladkowski.mdb.entity.movies.domain.Movie;
import dev.gladkowski.mdb.entity.movies.presentation.BaseMovieItem;
import io.reactivex.functions.Function;

/**
 * Converts List<Movie> object into List<BaseMovieItem> object
 */
public interface MoviesViewModelConverter extends Function<List<Movie>, List<BaseMovieItem>> {
}
