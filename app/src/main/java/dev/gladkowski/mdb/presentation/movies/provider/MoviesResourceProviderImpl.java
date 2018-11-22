package dev.gladkowski.mdb.presentation.movies.provider;

import android.content.Context;

import dev.gladkowski.mdb.R;


/**
 * Implementation of MoviesResourceProvider
 */
public class MoviesResourceProviderImpl implements MoviesResourceProvider {

    private Context context;

    public MoviesResourceProviderImpl(Context context) {
        this.context = context;
    }

    @Override
    public String getTitle() {
        return context.getString(R.string.title_movies);
    }

    @Override
    public String getPosterW500Url() {
        return context.getString(R.string.url_poster_w500);
    }
}
