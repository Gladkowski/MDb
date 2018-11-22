package dev.gladkowski.mdb.domain.movies;

import java.util.List;

import dev.gladkowski.mdb.entity.movies.domain.Movie;
import io.reactivex.Single;

/**
 * Interactor for Movies
 */
public interface MoviesInteractor {

    /**
     * Get popular movies by page
     *
     * @param page number of the page
     */
    Single<List<Movie>> getMoviesByPage(int page);
}
