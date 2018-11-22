package dev.gladkowski.mdb.data.repository.moviedetails;


import dev.gladkowski.mdb.data.network.MovieDetailsApi;
import dev.gladkowski.mdb.data.repository.moviedetails.converter.MovieDetailsResponseConverter;
import dev.gladkowski.mdb.entity.moviedetails.domain.MovieDetails;
import io.reactivex.Single;

/**
 * Implementation of MovieDetailsRepository
 */
public class MovieDetailsRepositoryImpl implements MovieDetailsRepository {

    private MovieDetailsApi movieDetailsApi;
    private MovieDetailsResponseConverter converter;

    public MovieDetailsRepositoryImpl(MovieDetailsApi movieDetailsApi,
                                      MovieDetailsResponseConverter converter) {
        this.movieDetailsApi = movieDetailsApi;
        this.converter = converter;
    }

    /**
     * Get detailed movie info by id
     *
     * @param id id of the movie
     */
    @Override
    public Single<MovieDetails> getMovieDetails(int id) {
        return movieDetailsApi.getMovieDetails(id)
                .map(converter);
    }
}
