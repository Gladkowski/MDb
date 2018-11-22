package dev.gladkowski.mdb.presentation.movies.pagination;

import java.util.Collections;
import java.util.List;

import dev.gladkowski.mdb.domain.movies.MoviesInteractor;
import dev.gladkowski.mdb.entity.movies.presentation.BaseMovieItem;
import dev.gladkowski.mdb.presentation.common.pagination.State;
import dev.gladkowski.mdb.presentation.common.pagination.ViewController;
import dev.gladkowski.mdb.presentation.movies.converter.MoviesViewModelConverter;
import io.reactivex.disposables.Disposable;

public class MoviesPaginatorImpl implements MoviesPaginator {

    private MoviesInteractor interactor;
    private ViewController<BaseMovieItem> viewController;
    private MoviesViewModelConverter converter;

    private int currentPage;
    private int defaultPage = 1;

    private State currentState = new INITIAL_STATE();
    private List<BaseMovieItem> currentData = Collections.emptyList();
    private Disposable disposable;

    public MoviesPaginatorImpl(MoviesInteractor interactor,
                               ViewController<BaseMovieItem> viewController,
                               MoviesViewModelConverter converter) {
        this.interactor = interactor;
        this.viewController = viewController;
        this.converter = converter;
    }

    @Override
    public boolean isFirstPage() {
        return currentPage == defaultPage;
    }

    @Override
    public void refresh() {
        currentState.refresh();
    }

    @Override
    public void loadNewPage() {
        currentState.loadNewPage();
    }

    @Override
    public void release() {
        currentState.release();
    }

    private void loadPage(int page) {
        unsubscribe();

        disposable = interactor.getMoviesByPage(page)
                .map(converter)
                .subscribe(items -> currentState.newData(items),
                        throwable -> currentState.error(throwable));
    }

    private void unsubscribe() {
        if (disposable != null) {
            if (!disposable.isDisposed()) {
                disposable.dispose();
            }
        }
    }

    private void increasePage() {
        currentPage += 1;
    }

    ///////////////////////////////////////////////////////////////////////////
    // STATES
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Initial paginator state
     */
    private class INITIAL_STATE implements State {

        @Override
        public void refresh() {
            currentState = new REFRESH_STATE();
            viewController.showRefreshProgress(true);
            loadPage(defaultPage);
        }

        @Override
        public void loadNewPage() {
        }

        @Override
        public void release() {
            currentState = new RELEASED_STATE();
            unsubscribe();
        }

        @Override
        public void newData(List<BaseMovieItem> list) {
        }

        @Override
        public void error(Throwable throwable) {
        }
    }

    /**
     * State for empty list
     */
    private class EMPTY_DATA_STATE implements State {

        @Override
        public void refresh() {
            currentState = new REFRESH_STATE();
            viewController.showRefreshProgress(true);
            loadPage(defaultPage);
        }

        @Override
        public void loadNewPage() {
        }

        @Override
        public void release() {
            currentState = new RELEASED_STATE();
            unsubscribe();
        }

        @Override
        public void newData(List<BaseMovieItem> list) {
        }

        @Override
        public void error(Throwable throwable) {
        }
    }

    /**
     * State for loaded list
     */
    private class DATA_STATE implements State {

        @Override
        public void refresh() {
            currentState = new REFRESH_STATE();
            viewController.showRefreshProgress(true);
            loadPage(defaultPage);
        }

        @Override
        public void loadNewPage() {
            currentState = new PAGE_PROGRESS_STATE();
            viewController.showPageProgress(true);
            increasePage();
            loadPage(currentPage);
        }

        @Override
        public void release() {
            currentState = new RELEASED_STATE();
            unsubscribe();
        }

        @Override
        public void newData(List<BaseMovieItem> list) {
        }

        @Override
        public void error(Throwable throwable) {
            viewController.showError(throwable);
        }
    }

    /**
     * State for refreshing list
     */
    private class REFRESH_STATE implements State {

        @Override
        public void refresh() {
        }

        @Override
        public void loadNewPage() {
        }

        @Override
        public void release() {
            currentState = new RELEASED_STATE();
            unsubscribe();
        }

        @Override
        public void newData(List<BaseMovieItem> list) {
            if (!list.isEmpty()) {
                currentState = new DATA_STATE();
                currentData.clear();
                currentData = list;
                currentPage = defaultPage;
                viewController.showRefreshProgress(false);
                viewController.showEmptyView(false);
                viewController.showList(true, currentData);
            } else {
                currentState = new EMPTY_DATA_STATE();
                viewController.showEmptyView(true);

                currentData.clear();
                viewController.showList(false, null);
                viewController.showRefreshProgress(false);
            }
        }

        @Override
        public void error(Throwable throwable) {
            currentState = new DATA_STATE();
            viewController.showRefreshProgress(false);
            viewController.showError(throwable);
        }
    }

    /**
     * State for progress page
     */
    private class PAGE_PROGRESS_STATE implements State {

        @Override
        public void refresh() {
            currentState = new REFRESH_STATE();
            viewController.showPageProgress(false);
            viewController.showRefreshProgress(true);
            loadPage(defaultPage);
        }

        @Override
        public void loadNewPage() {
        }

        @Override
        public void release() {
            currentState = new RELEASED_STATE();
            unsubscribe();
        }

        @Override
        public void newData(List<BaseMovieItem> list) {
            if (!list.isEmpty()) {
                currentState = new DATA_STATE();
                currentData = list;
                viewController.showPageProgress(false);
                viewController.showList(true, currentData);
            } else {
                currentState = new ALL_DATA_STATE();
                viewController.showPageProgress(false);
            }
        }

        @Override
        public void error(Throwable throwable) {
            currentState = new DATA_STATE();
            viewController.showPageProgress(false);
            viewController.showError(throwable);
        }
    }

    /**
     * State for all available data is loaded
     */
    private class ALL_DATA_STATE implements State {

        @Override
        public void refresh() {
            currentState = new REFRESH_STATE();
            viewController.showRefreshProgress(true);
            loadPage(defaultPage);
        }

        @Override
        public void loadNewPage() {
        }

        @Override
        public void release() {
            currentState = new RELEASED_STATE();
            unsubscribe();
        }

        @Override
        public void newData(List<BaseMovieItem> list) {
        }

        @Override
        public void error(Throwable throwable) {
        }
    }

    /**
     * State for paginator released
     */
    private class RELEASED_STATE implements State {

        @Override
        public void refresh() {
        }

        @Override
        public void loadNewPage() {
        }

        @Override
        public void release() {
        }

        @Override
        public void newData(List<BaseMovieItem> list) {
        }

        @Override
        public void error(Throwable throwable) {
        }
    }
}
