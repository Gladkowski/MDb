package dev.gladkowski.mdb.presentation.common.pagination;

import java.util.List;

import dev.gladkowski.mdb.entity.movies.presentation.BaseMovieItem;


/**
 * Paginator state interface
 */
public interface State {

    /**
     * Refresh list
     */
    void refresh();

    /**
     * Load new page
     */
    void loadNewPage();

    /**
     * Release paginator
     */
    void release();

    /**
     * New list items loaded
     */
    void newData(List<BaseMovieItem> list);

    /**
     * Error happened
     */
    void error(Throwable throwable);
}
