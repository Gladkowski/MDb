package dev.gladkowski.mdb.di.movies;

import dagger.Module;
import dagger.Provides;
import dev.gladkowski.mdb.data.network.MoviesApi;
import dev.gladkowski.mdb.data.repository.movies.MoviesRepository;
import dev.gladkowski.mdb.data.repository.movies.MoviesRepositoryImpl;
import dev.gladkowski.mdb.data.repository.movies.converter.MovieListResponseConverter;


@Module
public interface MoviesRepositoryModule {

    @Provides
    static MoviesRepository provideMoviesRepository(MoviesApi moviesApi,
                                                    MovieListResponseConverter converter) {
        return new MoviesRepositoryImpl(moviesApi, converter);
    }
}
