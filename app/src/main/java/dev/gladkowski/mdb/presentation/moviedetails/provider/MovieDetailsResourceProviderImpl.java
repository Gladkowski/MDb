package dev.gladkowski.mdb.presentation.moviedetails.provider;

import android.content.Context;

import dev.gladkowski.mdb.R;


/**
 * Implementation of MovieDetailsResourceProvider
 */
public class MovieDetailsResourceProviderImpl implements MovieDetailsResourceProvider {

    private Context context;

    public MovieDetailsResourceProviderImpl(Context context) {
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

    @Override
    public String getBackdropW1280Url() {
        return context.getString(R.string.url_backdrop_w1280);
    }

    @Override
    public String getSingleSpace() {
        return context.getString(R.string.single_space);
    }

    @Override
    public String getNoAvailableOverview() {
        return context.getString(R.string.no_available_overview);
    }

    @Override
    public String getOutOfTen() {
        return context.getString(R.string.out_of_10);
    }

    @Override
    public String getRuntimeUnknown() {
        return context.getString(R.string.runtime_unknown);
    }

    @Override
    public String getMin() {
        return context.getString(R.string.minutes_short);
    }
}
