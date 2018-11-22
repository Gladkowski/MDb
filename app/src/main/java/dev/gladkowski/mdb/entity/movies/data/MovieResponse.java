package dev.gladkowski.mdb.entity.movies.data;

import com.google.gson.annotations.SerializedName;

/**
 * Response class that returns movie information from server
 */
public class MovieResponse {

    @SerializedName("id")
    private Integer id;

    @SerializedName("title")
    private String title;

    @SerializedName("poster_path")
    private String posterPath;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterPath() {
        return posterPath;
    }
}
