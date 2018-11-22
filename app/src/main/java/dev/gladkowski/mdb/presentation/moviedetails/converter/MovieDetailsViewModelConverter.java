package dev.gladkowski.mdb.presentation.moviedetails.converter;


import dev.gladkowski.mdb.entity.moviedetails.domain.MovieDetails;
import dev.gladkowski.mdb.entity.moviedetails.presentation.MovieDetailsViewModel;
import io.reactivex.functions.Function;

/**
 * Converts MovieDetails object into MovieDetailsViewModel object
 */
public interface MovieDetailsViewModelConverter extends Function<MovieDetails, MovieDetailsViewModel> {
}
