package dev.gladkowski.mdb.entity.movies.presentation;

import android.support.annotation.Nullable;

import dev.gladkowski.mdb.entity.common.presentation.ItemViewType;


/**
 * Visual class for movie information
 */
public class MovieViewModel extends BaseMovieItem {

    private int id;
    private String title;
    @Nullable
    private String posterPath;

    public MovieViewModel(int id, String title, @Nullable String posterPath) {
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

    @Override
    public ItemViewType getItemViewType() {
        return ItemViewType.ITEM;
    }
}
