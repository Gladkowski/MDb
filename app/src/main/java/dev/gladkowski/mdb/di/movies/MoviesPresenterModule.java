package dev.gladkowski.mdb.di.movies;

import dagger.Module;
import dagger.Provides;
import dev.gladkowski.mdb.domain.movies.MoviesInteractor;
import dev.gladkowski.mdb.presentation.movies.MoviesPresenter;
import dev.gladkowski.mdb.presentation.movies.converter.MoviesViewModelConverter;
import dev.gladkowski.mdb.presentation.movies.provider.MoviesResourceProvider;
import dev.gladkowski.mdb.utils.rx.ErrorResourceProvider;
import ru.terrakok.cicerone.Router;

@Module
public interface MoviesPresenterModule {

    @Provides
    static MoviesPresenter provideMoviesPresenter(Router router,
                                                  ErrorResourceProvider errorResourceProvider,
                                                  MoviesResourceProvider resourceProvider,
                                                  MoviesInteractor moviesInteractor,
                                                  MoviesViewModelConverter converter) {
        return new MoviesPresenter(router, errorResourceProvider,
                resourceProvider, moviesInteractor, converter);
    }
}
