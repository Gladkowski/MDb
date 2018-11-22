package dev.gladkowski.mdb.di.moviedeatils;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import dev.gladkowski.mdb.data.repository.moviedetails.converter.MovieDetailsResponseConverter;
import dev.gladkowski.mdb.data.repository.moviedetails.converter.MovieDetailsResponseConverterImpl;
import dev.gladkowski.mdb.presentation.moviedetails.converter.MovieDetailsViewModelConverter;
import dev.gladkowski.mdb.presentation.moviedetails.converter.MovieDetailsViewModelConverterImpl;
import dev.gladkowski.mdb.presentation.moviedetails.provider.MovieDetailsResourceProvider;
import dev.gladkowski.mdb.presentation.moviedetails.provider.MovieDetailsResourceProviderImpl;


@Module
public interface MovieDetailsUtilsModule {

    @Provides
    static MovieDetailsResourceProvider provideMovieDetailsResourceProvider(Context context) {
        return new MovieDetailsResourceProviderImpl(context);
    }

    @Provides
    static MovieDetailsResponseConverter provideMovieListResponseConverter() {
        return new MovieDetailsResponseConverterImpl();
    }

    @Provides
    static MovieDetailsViewModelConverter provideMovieDetailsViewModelConverter(MovieDetailsResourceProvider resourceProvider) {
        return new MovieDetailsViewModelConverterImpl(resourceProvider);
    }
}
