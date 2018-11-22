package dev.gladkowski.mdb.presentation.moviedetails.provider;


import dev.gladkowski.mdb.presentation.common.fragment.BaseFragmentResourceProvider;

/**
 * Provides resources for MovieDetailsFragment
 */
public interface MovieDetailsResourceProvider extends BaseFragmentResourceProvider {

    /**
     * Returns part of URL for getting poster image with 500 width
     */
    String getPosterW500Url();

    /**
     * Returns part of URL for getting backdrop image with 1280 width
     */
    String getBackdropW1280Url();

    String getSingleSpace();

    String getNoAvailableOverview();

    String getOutOfTen();

    String getRuntimeUnknown();

    String getMin();

}
