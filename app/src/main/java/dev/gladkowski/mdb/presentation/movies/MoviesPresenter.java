package dev.gladkowski.mdb.presentation.movies;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;

import dev.gladkowski.mdb.presentation.common.activity.BaseNetworkPresenter;
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

    public MoviesPresenter(@NonNull Router router,
                           @NonNull ErrorResourceProvider errorResourceProvider) {
        this.router = router;
        this.errorResourceProvider = errorResourceProvider;
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

    }
}
