package dev.gladkowski.mdb.presentation.movies;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;

import java.util.List;

import dev.gladkowski.mdb.domain.movies.MoviesInteractor;
import dev.gladkowski.mdb.entity.movies.presentation.BaseMovieItem;
import dev.gladkowski.mdb.presentation.common.activity.BaseNetworkPresenter;
import dev.gladkowski.mdb.presentation.common.pagination.ViewController;
import dev.gladkowski.mdb.presentation.movies.converter.MoviesViewModelConverter;
import dev.gladkowski.mdb.presentation.movies.pagination.MoviesPaginator;
import dev.gladkowski.mdb.presentation.movies.pagination.MoviesPaginatorImpl;
import dev.gladkowski.mdb.presentation.movies.provider.MoviesResourceProvider;
import dev.gladkowski.mdb.utils.rx.ErrorResourceProvider;
import ru.terrakok.cicerone.Router;

/**
 * Presenter for MoviesFragment
 */
@InjectViewState
public class MoviesPresenter extends BaseNetworkPresenter<MoviesView> {

    @NonNull
    private Router router;
    @NonNull
    private ErrorResourceProvider errorResourceProvider;
    @NonNull
    private MoviesResourceProvider resourceProvider;
    @NonNull
    private MoviesInteractor moviesInteractor;
    @NonNull
    private MoviesViewModelConverter converter;

    private MoviesPaginator paginator;

    /**
     * Pagination callback interface for view
     */
    private ViewController<BaseMovieItem> viewController = new ViewController<BaseMovieItem>() {
        @Override
        public void showEmptyView(boolean show) {
            if (show) {
//                showEmptyListView;
            } else {
                getViewState().clearList();
            }
        }

        @Override
        public void showList(boolean show, List<BaseMovieItem> list) {
            if (show) {
                if (paginator.isFirstPage()) {
                    getViewState().showList(list);
                } else {
                    getViewState().addMoreItems(list);
                }
            } else {
                getViewState().clearList();
            }
        }

        @Override
        public void showRefreshProgress(boolean show) {
            if (show) {
                getViewState().onShowLoading();
            } else {
                getViewState().onHideLoading();
            }
        }

        @Override
        public void showPageProgress(boolean show) {
            if (show) {
                getViewState().onShowPageLoading();
            } else {
                getViewState().onHidePageLoading();
            }

        }

        @Override
        public void showError(Throwable throwable) {
            processErrors(throwable);
        }
    };


    public MoviesPresenter(@NonNull Router router,
                           @NonNull ErrorResourceProvider errorResourceProvider,
                           @NonNull MoviesResourceProvider resourceProvider,
                           @NonNull MoviesInteractor moviesInteractor,
                           @NonNull MoviesViewModelConverter converter) {
        this.router = router;
        this.errorResourceProvider = errorResourceProvider;
        this.resourceProvider = resourceProvider;
        this.moviesInteractor = moviesInteractor;
        this.converter = converter;
    }

    @NonNull
    @Override
    public Router getRouter() {
        return router;
    }

    @NonNull
    @Override
    public ErrorResourceProvider getErrorResourceProvider() {
        return errorResourceProvider;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    @Override
    public void initData() {
        getViewState().onSetTitle(resourceProvider.getTitle());
        paginator = new MoviesPaginatorImpl(moviesInteractor, viewController, converter);
        paginator.refresh();
    }

    /**
     * Refresh list
     */
    void onRefresh() {
        paginator.refresh();
    }

    /**
     * Load next page
     */
    void loadNextPage() {
        paginator.loadNewPage();
    }

    void onItemClicked(int id) {
        //TODO: navigate to movie details
    }

    /**
     * Triggered on back button pressed
     */
    @Override
    public void onBackPressed() {
        getRouter().exit();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (paginator != null) {
            paginator.release();
        }
    }
}
