package dev.gladkowski.mdb.di.movies;

import dagger.Module;
import dagger.Provides;
import dev.gladkowski.mdb.data.repository.movies.MoviesRepository;
import dev.gladkowski.mdb.domain.movies.MoviesInteractor;
import dev.gladkowski.mdb.domain.movies.MoviesInteractorImpl;
import dev.gladkowski.mdb.utils.rx.RxUtils;
import dev.gladkowski.mdb.utils.rx.SingleErrorHandler;


@Module
public interface MoviesInteractorModule {

    @Provides
    static MoviesInteractor provideMoviesInteractor(MoviesRepository moviesRepository,
                                                    SingleErrorHandler singleErrorHandler,
                                                    RxUtils rxUtils) {
        return new MoviesInteractorImpl(moviesRepository, singleErrorHandler, rxUtils);
    }
}
