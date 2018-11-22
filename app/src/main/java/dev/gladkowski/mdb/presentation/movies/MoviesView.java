package dev.gladkowski.mdb.presentation.movies;

import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import dev.gladkowski.mdb.entity.movies.presentation.BaseMovieItem;
import dev.gladkowski.mdb.presentation.common.fragment.BaseFragmentView;


/**
 * Interface for MoviesFragment
 */
public interface MoviesView extends BaseFragmentView {

    /**
     * Show the list of items
     */
    @StateStrategyType(AddToEndStrategy.class)
    void showList(List<BaseMovieItem> items);

    /**
     * Add more items to the list and show it
     */
    @StateStrategyType(AddToEndStrategy.class)
    void addMoreItems(List<BaseMovieItem> items);

    /**
     * Clear list of items
     */
    void clearList();

    /**
     * Show loading at the end of the list
     */
    void onShowPageLoading();

    /**
     * Show loading at the end of the list
     */
    void onHidePageLoading();
}
