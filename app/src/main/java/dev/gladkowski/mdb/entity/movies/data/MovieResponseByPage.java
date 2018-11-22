package dev.gladkowski.mdb.entity.movies.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Response class that returns 20 movies of specified page from server
 */
public class MovieResponseByPage {

    @SerializedName("page")
    private Integer page;

    @SerializedName("results")
    private List<MovieResponse> results;

    public Integer getPage() {
        return page;
    }

    public List<MovieResponse> getResults() {
        return results;
    }
}
