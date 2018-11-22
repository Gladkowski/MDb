package dev.gladkowski.mdb.data.network;

import dev.gladkowski.mdb.entity.movies.data.MovieResponseByPage;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesApi {

    /**
     * Get popular movies by page
     *
     * @param page number of the page
     */
    @GET("/3/movie/popular?")
    Single<MovieResponseByPage> getPopularMoviesByPage(@Query("page") int page);

}
