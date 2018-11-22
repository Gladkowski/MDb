package dev.gladkowski.mdb.domain.moviedetails;

import dev.gladkowski.mdb.entity.moviedetails.domain.MovieDetails;
import io.reactivex.Single;

/**
 * Interactor for MovieDetails
 */
public interface MovieDetailsInteractor {

    /**
     * Get detailed movie info by id
     *
     * @param id id of the movie
     */
    Single<MovieDetails> getMovieDetails(int id);
}
