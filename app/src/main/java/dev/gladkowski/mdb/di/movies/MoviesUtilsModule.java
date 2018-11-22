package dev.gladkowski.mdb.di.movies;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import dev.gladkowski.mdb.data.repository.movies.converter.MovieListResponseConverter;
import dev.gladkowski.mdb.data.repository.movies.converter.MovieListResponseConverterImpl;
import dev.gladkowski.mdb.presentation.movies.converter.MoviesViewModelConverter;
import dev.gladkowski.mdb.presentation.movies.converter.MoviesViewModelConverterImpl;
import dev.gladkowski.mdb.presentation.movies.provider.MoviesResourceProvider;
import dev.gladkowski.mdb.presentation.movies.provider.MoviesResourceProviderImpl;


@Module
public interface MoviesUtilsModule {

    @Provides
    static MoviesResourceProvider provideMoviesResourceProvider(Context context) {
        return new MoviesResourceProviderImpl(context);
    }

    @Provides
    static MovieListResponseConverter provideMovieListResponseConverter() {
        return new MovieListResponseConverterImpl();
    }

    @Provides
    static MoviesViewModelConverter provideMoviesViewModelConverter(MoviesResourceProvider resourceProvider) {
        return new MoviesViewModelConverterImpl(resourceProvider);
    }
}
