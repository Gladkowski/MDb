package dev.gladkowski.mdb.presentation.moviedetails;

import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import dev.gladkowski.mdb.entity.moviedetails.presentation.MovieDetailsViewModel;
import dev.gladkowski.mdb.presentation.common.fragment.BaseFragmentView;


/**
 * Interface for MovieDetailsFragment
 */
public interface MovieDetailsView extends BaseFragmentView {

    /**
     * Display detailed movie data
     */
    @StateStrategyType(AddToEndStrategy.class)
    void setMovieData(MovieDetailsViewModel movieDetails);
}
