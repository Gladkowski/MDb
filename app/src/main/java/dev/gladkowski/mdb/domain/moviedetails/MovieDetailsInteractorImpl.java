package dev.gladkowski.mdb.domain.moviedetails;


import dev.gladkowski.mdb.data.repository.moviedetails.MovieDetailsRepository;
import dev.gladkowski.mdb.entity.moviedetails.domain.MovieDetails;
import dev.gladkowski.mdb.utils.rx.RxUtils;
import dev.gladkowski.mdb.utils.rx.SingleErrorHandler;
import io.reactivex.Single;

/**
 * Implementation of MovieDetailsInteractor
 */
public class MovieDetailsInteractorImpl implements MovieDetailsInteractor {

    private MovieDetailsRepository movieDetailsRepository;
    private SingleErrorHandler singleErrorHandler;
    private RxUtils rxUtils;

    public MovieDetailsInteractorImpl(MovieDetailsRepository movieDetailsRepository,
                                      SingleErrorHandler singleErrorHandler, RxUtils rxUtils) {
        this.movieDetailsRepository = movieDetailsRepository;
        this.singleErrorHandler = singleErrorHandler;
        this.rxUtils = rxUtils;
    }

    /**
     * Get detailed movie info by id
     *
     * @param id id of the movie
     */
    @Override
    public Single<MovieDetails> getMovieDetails(int id) {
        return movieDetailsRepository.getMovieDetails(id)
                .compose((SingleErrorHandler<MovieDetails>) singleErrorHandler)
                .compose(rxUtils.applySingleSchedulers());
    }
}
