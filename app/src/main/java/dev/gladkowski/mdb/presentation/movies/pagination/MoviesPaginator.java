package dev.gladkowski.mdb.presentation.movies.pagination;


import dev.gladkowski.mdb.presentation.common.pagination.Paginator;

public interface MoviesPaginator extends Paginator {

    /**
     * Returns if the current page is first
     */
    boolean isFirstPage();
}
