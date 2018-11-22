package dev.gladkowski.mdb.di.moviedeatils;

import dagger.Module;
import dagger.Provides;
import dev.gladkowski.mdb.data.network.MovieDetailsApi;
import dev.gladkowski.mdb.data.repository.moviedetails.MovieDetailsRepository;
import dev.gladkowski.mdb.data.repository.moviedetails.MovieDetailsRepositoryImpl;
import dev.gladkowski.mdb.data.repository.moviedetails.converter.MovieDetailsResponseConverter;


@Module
public interface MovieDetailsRepositoryModule {

    @Provides
    static MovieDetailsRepository provideMovieDetailsRepository(MovieDetailsApi api,
                                                                MovieDetailsResponseConverter converter) {
        return new MovieDetailsRepositoryImpl(api, converter);
    }
}
