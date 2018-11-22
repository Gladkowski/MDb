package dev.gladkowski.mdb.di.moviedeatils;

import dagger.Module;
import dagger.Provides;
import dev.gladkowski.mdb.data.repository.moviedetails.converter.MovieDetailsResponseConverter;
import dev.gladkowski.mdb.data.repository.moviedetails.converter.MovieDetailsResponseConverterImpl;


@Module
public interface MovieDetailsUtilsModule {

    @Provides
    static MovieDetailsResponseConverter provideMovieListResponseConverter() {
        return new MovieDetailsResponseConverterImpl();
    }

}
