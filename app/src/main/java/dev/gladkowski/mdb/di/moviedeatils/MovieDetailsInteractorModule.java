package dev.gladkowski.mdb.di.moviedeatils;

import dagger.Module;
import dagger.Provides;
import dev.gladkowski.mdb.data.repository.moviedetails.MovieDetailsRepository;
import dev.gladkowski.mdb.domain.moviedetails.MovieDetailsInteractor;
import dev.gladkowski.mdb.domain.moviedetails.MovieDetailsInteractorImpl;
import dev.gladkowski.mdb.utils.rx.RxUtils;
import dev.gladkowski.mdb.utils.rx.SingleErrorHandler;


@Module
public interface MovieDetailsInteractorModule {

    @Provides
    static MovieDetailsInteractor provideMovieDetailsInteractor(MovieDetailsRepository repository,
                                                                SingleErrorHandler singleErrorHandler,
                                                                RxUtils rxUtils) {
        return new MovieDetailsInteractorImpl(repository, singleErrorHandler, rxUtils);
    }
}
