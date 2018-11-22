package dev.gladkowski.mdb.entity.movies.domain;

import android.support.annotation.Nullable;

/**
 * Domain class for movie information
 */
public class Movie {

    private int id;
    private String title;
    @Nullable
    private String posterPath;

    public Movie(int id, String title, @Nullable String posterPath) {
        this.id = id;
        this.title = title;
        this.posterPath = posterPath;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Nullable
    public String getPosterPath() {
        return posterPath;
    }
}
