package dev.gladkowski.mdb.data.repository.moviedetails;

import dev.gladkowski.mdb.entity.moviedetails.domain.MovieDetails;
import io.reactivex.Single;

/**
 * Repository for MovieDetails
 */
public interface MovieDetailsRepository {

    /**
     * Get detailed movie info by id
     *
     * @param id id of the movie
     */
    Single<MovieDetails> getMovieDetails(int id);

}
