package dev.gladkowski.mdb.entity.moviedetails.domain;

import android.support.annotation.Nullable;

import org.joda.time.DateTime;

/**
 * Domain class for detailed movie information
 */
public class MovieDetails {

    private Integer id;
    private String title;
    @Nullable
    private String overview;
    @Nullable
    private String posterPath;
    @Nullable
    private String backdropPath;
    private DateTime releaseDate;
    private Double voteAverage;
    @Nullable
    private Integer runtime;

    public MovieDetails(Integer id,
                        String title,
                        @Nullable String overview,
                        @Nullable String posterPath,
                        @Nullable String backdropPath,
                        DateTime releaseDate,
                        Double voteAverage,
                        @Nullable Integer runtime) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.posterPath = posterPath;
        this.backdropPath = backdropPath;
        this.releaseDate = releaseDate;
        this.voteAverage = voteAverage;
        this.runtime = runtime;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Nullable
    public String getOverview() {
        return overview;
    }

    @Nullable
    public String getPosterPath() {
        return posterPath;
    }

    @Nullable
    public String getBackdropPath() {
        return backdropPath;
    }

    public DateTime getReleaseDate() {
        return releaseDate;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    @Nullable
    public Integer getRuntime() {
        return runtime;
    }
}
