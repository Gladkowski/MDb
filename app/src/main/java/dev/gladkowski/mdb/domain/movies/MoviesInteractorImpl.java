package dev.gladkowski.mdb.domain.movies;

import java.util.List;

import dev.gladkowski.mdb.data.repository.movies.MoviesRepository;
import dev.gladkowski.mdb.entity.movies.domain.Movie;
import dev.gladkowski.mdb.utils.rx.RxUtils;
import dev.gladkowski.mdb.utils.rx.SingleErrorHandler;
import io.reactivex.Single;

/**
 * Implementation of MoviesInteractor
 */
public class MoviesInteractorImpl implements MoviesInteractor {

    private MoviesRepository moviesRepository;
    private SingleErrorHandler singleErrorHandler;
    private RxUtils rxUtils;

    public MoviesInteractorImpl(MoviesRepository moviesRepository,
                                SingleErrorHandler singleErrorHandler,
                                RxUtils rxUtils) {
        this.moviesRepository = moviesRepository;
        this.singleErrorHandler = singleErrorHandler;
        this.rxUtils = rxUtils;
    }

    /**
     * Get popular movies by page
     *
     * @param page number of the page
     */
    @Override
    public Single<List<Movie>> getMoviesByPage(int page) {
        return moviesRepository.getPopularMoviesByPage(page)
                .compose((SingleErrorHandler<List<Movie>>) singleErrorHandler)
                .compose(rxUtils.applySingleSchedulers());
    }
}
