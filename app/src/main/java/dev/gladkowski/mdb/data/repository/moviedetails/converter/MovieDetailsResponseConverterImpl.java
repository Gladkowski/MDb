package dev.gladkowski.mdb.data.repository.moviedetails.converter;


import dev.gladkowski.mdb.entity.moviedetails.data.MovieDetailsResponse;
import dev.gladkowski.mdb.entity.moviedetails.domain.MovieDetails;

/**
 * Implementation of MovieDetailsResponseConverter
 */
public class MovieDetailsResponseConverterImpl implements MovieDetailsResponseConverter {

    @Override
    public MovieDetails apply(MovieDetailsResponse response) throws Exception {
        return new MovieDetails(response.getId(),
                response.getTitle(),
                response.getOverview(),
                response.getPosterPath(),
                response.getBackdropPath(),
                response.getReleaseDate(),
                response.getVoteAverage(),
                response.getRuntime());
    }
}
