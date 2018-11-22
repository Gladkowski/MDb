package dev.gladkowski.mdb.data.repository.moviedetails.converter;


import dev.gladkowski.mdb.entity.moviedetails.data.MovieDetailsResponse;
import dev.gladkowski.mdb.entity.moviedetails.domain.MovieDetails;
import io.reactivex.functions.Function;

/**
 * Converter that converts MovieDetailsResponse object into MovieDetails object
 */
public interface MovieDetailsResponseConverter extends Function<MovieDetailsResponse, MovieDetails> {
}
