package dev.gladkowski.mdb.presentation.movies;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import dev.gladkowski.mdb.R;
import dev.gladkowski.mdb.entity.common.presentation.ItemViewType;
import dev.gladkowski.mdb.entity.movies.presentation.BaseMovieItem;
import dev.gladkowski.mdb.presentation.common.fragment.BaseFragment;
import dev.gladkowski.mdb.presentation.movies.adapter.MoviesAdapter;
import dev.gladkowski.mdb.presentation.movies.adapter.callback.MovieItemCallback;
import dev.gladkowski.mdb.presentation.movies.constants.MoviesConstants;
import dev.gladkowski.mdb.utils.imageloader.ImageLoader;


/**
 * Fragment with list of popular movies
 */
public class MoviesFragment extends BaseFragment<MoviesPresenter, MoviesView> implements MoviesView,
        MovieItemCallback {

    @InjectPresenter
    MoviesPresenter moviesPresenter;

    @Inject
    ImageLoader imageLoader;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private MoviesAdapter moviesAdapter;

    public MoviesFragment() {
    }

    public static MoviesFragment newInstance() {
        MoviesFragment fragment = new MoviesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @ProvidePresenter
    MoviesPresenter provideMoviesPresenter() {
        return presenterProvider.get();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initList();
    }

    ///////////////////////////////////////////////////////////////////////////
    // GETTERS
    ///////////////////////////////////////////////////////////////////////////

    @Override
    protected MoviesPresenter getPresenter() {
        return moviesPresenter;
    }

    ///////////////////////////////////////////////////////////////////////////
    // MVP
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public void onSetTitle(String title) {
        toolbar.setTitle(title);
    }

    /**
     * GridLayoutManager initialization
     */
    private void initList() {
        moviesAdapter = new MoviesAdapter(this, imageLoader);
        recyclerView.setAdapter(moviesAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), MoviesConstants.SPAN_COUNT);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (moviesAdapter.getItemByPosition(position).getItemViewType() == ItemViewType.HEADER) {
                    return MoviesConstants.DOUBLE_SPAN;
                } else if (moviesAdapter.getItemByPosition(position).getItemViewType() == ItemViewType.ITEM) {
                    return MoviesConstants.SINGLE_SPAN;
                } else return MoviesConstants.SINGLE_SPAN;
            }
        });

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int visibleItemPosition = layoutManager.findLastCompletelyVisibleItemPosition() + MoviesConstants.INVISIBLE_ITEMS_COUNT;
                int itemCount = layoutManager.getItemCount() - 1;

                if (visibleItemPosition >= itemCount) {
                    getPresenter().loadNextPage();
                }
            }
        });

        swipeRefreshLayout.setOnRefreshListener(() -> getPresenter().onRefresh());
    }

    @Override
    public void showList(List<BaseMovieItem> items) {
        moviesAdapter.addItems(items);
    }

    @Override
    public void addMoreItems(List<BaseMovieItem> items) {
        moviesAdapter.addMoreItems(items);
    }

    @Override
    public void clearList() {
        moviesAdapter.clearList();
    }

    @Override
    public void onShowLoading() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void onHideLoading() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onShowPageLoading() {
        moviesAdapter.showPageLoading();
    }

    @Override
    public void onHidePageLoading() {
        moviesAdapter.hidePageLoading();
    }

    ///////////////////////////////////////////////////////////////////////////
    // UI METHODS
    ///////////////////////////////////////////////////////////////////////////


    @Override
    public void onItemClick(int id) {
        getPresenter().onItemClicked(id);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}
