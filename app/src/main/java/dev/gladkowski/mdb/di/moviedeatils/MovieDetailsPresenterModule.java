package dev.gladkowski.mdb.di.moviedeatils;

import dagger.Module;
import dagger.Provides;
import dev.gladkowski.mdb.domain.moviedetails.MovieDetailsInteractor;
import dev.gladkowski.mdb.presentation.moviedetails.MovieDetailsPresenter;
import dev.gladkowski.mdb.presentation.moviedetails.converter.MovieDetailsViewModelConverter;
import dev.gladkowski.mdb.presentation.moviedetails.provider.MovieDetailsResourceProvider;
import dev.gladkowski.mdb.utils.rx.ErrorResourceProvider;
import ru.terrakok.cicerone.Router;

@Module
public interface MovieDetailsPresenterModule {

    @Provides
    static MovieDetailsPresenter provideMovieDetailsPresenter(Router router,
                                                              ErrorResourceProvider errorResourceProvider,
                                                              MovieDetailsResourceProvider resourceProvider,
                                                              MovieDetailsInteractor interactor,
                                                              MovieDetailsViewModelConverter converter) {
        return new MovieDetailsPresenter(router, errorResourceProvider,
                resourceProvider, interactor, converter);
    }
}
