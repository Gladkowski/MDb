package dev.gladkowski.mdb.entity.moviedetails.data;

import com.google.gson.annotations.SerializedName;

import org.joda.time.DateTime;

/**
 * Response class that returns detailed movie information from server
 */
public class MovieDetailsResponse {

    @SerializedName("id")
    private Integer id;

    @SerializedName("title")
    private String title;

    @SerializedName("overview")
    private String overview;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("backdrop_path")
    private String backdropPath;

    @SerializedName("release_date")
    private DateTime releaseDate;

    @SerializedName("vote_average")
    private Double voteAverage;

    @SerializedName("runtime")
    private Integer runtime;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public DateTime getReleaseDate() {
        return releaseDate;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public Integer getRuntime() {
        return runtime;
    }
}
