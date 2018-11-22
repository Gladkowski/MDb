package dev.gladkowski.mdb.entity.moviedetails.presentation;

import android.support.annotation.Nullable;

/**
 * Visual class for detailed movie information
 */
public class MovieDetailsViewModel {

    private Integer id;
    private String title;
    @Nullable
    private String overview;
    @Nullable
    private String posterPath;
    @Nullable
    private String backdropPath;
    private String releaseDate;
    private String voteAverage;
    @Nullable
    private String runtime;

    public MovieDetailsViewModel(Integer id, String title, @Nullable String overview,
                                 @Nullable String posterPath, @Nullable String backdropPath,
                                 String releaseDate, String voteAverage,
                                 @Nullable String runtime) {
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

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getVoteAverage() {
        return voteAverage;
    }

    @Nullable
    public String getRuntime() {
        return runtime;
    }
}
