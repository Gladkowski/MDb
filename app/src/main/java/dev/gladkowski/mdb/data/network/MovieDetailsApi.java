package dev.gladkowski.mdb.data.network;

import dev.gladkowski.mdb.entity.moviedetails.data.MovieDetailsResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MovieDetailsApi {

    /**
     * Get detailed movie info by id
     *
     * @param id id of the movie
     */
    @GET("/3/movie/{id}")
    Single<MovieDetailsResponse> getMovieDetails(@Path("id") int id);
}
