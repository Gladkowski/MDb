package dev.gladkowski.mdb.presentation.movies.provider;


import dev.gladkowski.mdb.presentation.common.fragment.BaseFragmentResourceProvider;

/**
 * Provides resources for MoviesFragment
 */
public interface MoviesResourceProvider extends BaseFragmentResourceProvider {

    /**
     * Returns part of URL for getting poster image with 500 width
     */
    String getPosterW500Url();

}
