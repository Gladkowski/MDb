package dev.gladkowski.mdb.di.movies;

import dagger.Module;
import dagger.Provides;
import dev.gladkowski.mdb.data.repository.movies.converter.MovieListResponseConverter;
import dev.gladkowski.mdb.data.repository.movies.converter.MovieListResponseConverterImpl;


@Module
public interface MoviesUtilsModule {

    @Provides
    static MovieListResponseConverter provideMovieListResponseConverter() {
        return new MovieListResponseConverterImpl();
    }

}
