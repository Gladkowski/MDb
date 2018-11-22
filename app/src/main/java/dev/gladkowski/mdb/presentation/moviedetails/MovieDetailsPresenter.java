package dev.gladkowski.mdb.presentation.moviedetails;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;

import dev.gladkowski.mdb.domain.moviedetails.MovieDetailsInteractor;
import dev.gladkowski.mdb.presentation.common.activity.BaseNetworkPresenter;
import dev.gladkowski.mdb.presentation.moviedetails.converter.MovieDetailsViewModelConverter;
import dev.gladkowski.mdb.presentation.moviedetails.provider.MovieDetailsResourceProvider;
import dev.gladkowski.mdb.utils.rx.ErrorResourceProvider;
import io.reactivex.disposables.Disposable;
import ru.terrakok.cicerone.Router;

/**
 * Presenter for MovieDetailsFragment
 */
@InjectViewState
public class MovieDetailsPresenter extends BaseNetworkPresenter<MovieDetailsView> {

    @NonNull
    private Router router;
    @NonNull
    private ErrorResourceProvider errorResourceProvider;
    @NonNull
    private MovieDetailsResourceProvider resourceProvider;
    @NonNull
    private MovieDetailsInteractor movieDetailsInteractor;
    @NonNull
    private MovieDetailsViewModelConverter converter;

    private int movieId;

    public MovieDetailsPresenter(@NonNull Router router,
                                 @NonNull ErrorResourceProvider errorResourceProvider,
                                 @NonNull MovieDetailsResourceProvider resourceProvider,
                                 @NonNull MovieDetailsInteractor movieDetailsInteractor,
                                 @NonNull MovieDetailsViewModelConverter converter) {
        this.router = router;
        this.errorResourceProvider = errorResourceProvider;
        this.resourceProvider = resourceProvider;
        this.movieDetailsInteractor = movieDetailsInteractor;
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
        getMovieDetails();
    }

    /**
     * Load detailed movie info
     */
    private void getMovieDetails() {
        getViewState().onShowLoading();

        Disposable subscription = movieDetailsInteractor.getMovieDetails(movieId)
                .map(converter)
                .subscribe(movieItem -> {
                    getViewState().setMovieData(movieItem);
                }, exception -> {
                    processErrors(exception);
                    getViewState().onHideLoading();
                    super.onBackPressed();
                });

        unsubscribeOnDestroy(subscription);
    }

    /**
     * Set id of the movie into field
     */
    void onSetMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        getViewState().onHideLoading();
    }
}
