package dev.gladkowski.mdb.data.repository.movies;


import java.util.List;

import dev.gladkowski.mdb.data.network.MoviesApi;
import dev.gladkowski.mdb.data.repository.movies.converter.MovieListResponseConverter;
import dev.gladkowski.mdb.entity.movies.domain.Movie;
import io.reactivex.Single;

/**
 * Implementation of MoviesRepository
 */
public class MoviesRepositoryImpl implements MoviesRepository {

    private MoviesApi moviesApi;
    private MovieListResponseConverter converter;

    public MoviesRepositoryImpl(MoviesApi moviesApi,
                                MovieListResponseConverter converter) {
        this.moviesApi = moviesApi;
        this.converter = converter;
    }

    /**
     * Get popular movies by page
     *
     * @param page number of the page
     */
    @Override
    public Single<List<Movie>> getPopularMoviesByPage(int page) {
        return moviesApi.getPopularMoviesByPage(page)
                .map(converter);
    }
}
