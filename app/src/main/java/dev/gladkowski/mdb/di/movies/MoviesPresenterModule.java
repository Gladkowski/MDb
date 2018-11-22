package dev.gladkowski.mdb.di.movies;

import dagger.Module;
import dagger.Provides;
import dev.gladkowski.mdb.presentation.movies.MoviesPresenter;
import dev.gladkowski.mdb.utils.rx.ErrorResourceProvider;
import ru.terrakok.cicerone.Router;

@Module
public interface MoviesPresenterModule {

    @Provides
    static MoviesPresenter provideMoviesPresenter(Router router,
                                                  ErrorResourceProvider errorResourceProvider) {
        return new MoviesPresenter(router, errorResourceProvider);
    }
}
