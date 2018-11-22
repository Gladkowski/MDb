package dev.gladkowski.mdb.data.repository.movies;


import java.util.List;

import dev.gladkowski.mdb.entity.movies.domain.Movie;
import io.reactivex.Single;

/**
 * Repository for Movies
 */
public interface MoviesRepository {

    /**
     * Get popular movies by page
     *
     * @param page number of the page
     */
    Single<List<Movie>> getPopularMoviesByPage(int page);

}
