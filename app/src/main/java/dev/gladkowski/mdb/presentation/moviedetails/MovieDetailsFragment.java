package dev.gladkowski.mdb.presentation.moviedetails;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import javax.inject.Inject;

import butterknife.BindView;
import dev.gladkowski.mdb.R;
import dev.gladkowski.mdb.entity.moviedetails.presentation.MovieDetailsViewModel;
import dev.gladkowski.mdb.presentation.common.constants.AppExtras;
import dev.gladkowski.mdb.presentation.common.fragment.BaseFragment;
import dev.gladkowski.mdb.utils.imageloader.ImageLoader;
import dev.gladkowski.mdb.utils.imageloader.glide.ImageLoaderCallback;

/**
 * Fragment that displays detailed movie information
 */
public class MovieDetailsFragment extends BaseFragment<MovieDetailsPresenter, MovieDetailsView> implements MovieDetailsView,
        ImageLoaderCallback {

    @InjectPresenter
    MovieDetailsPresenter movieDetailsPresenter;

    @Inject
    ImageLoader imageLoader;

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.image_toolbar)
    ImageView toolbarImage;
    @BindView(R.id.image_poster)
    ImageView imagePoster;
    @BindView(R.id.text_release_date)
    TextView textReleaseDate;
    @BindView(R.id.text_vote_average)
    TextView textVoteAverage;
    @BindView(R.id.text_runtime)
    TextView textRuntime;
    @BindView(R.id.text_overview)
    TextView text_overview;

    public MovieDetailsFragment() {
    }

    public static MovieDetailsFragment newInstance(int movieId) {
        MovieDetailsFragment fragment = new MovieDetailsFragment();
        Bundle args = new Bundle();
        args.putInt(AppExtras.ARGUMENT_MOVIE_ID, movieId);
        fragment.setArguments(args);
        return fragment;
    }

    @ProvidePresenter
    MovieDetailsPresenter provideMoviesPresenter() {
        return presenterProvider.get();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null && getArguments().containsKey(AppExtras.ARGUMENT_MOVIE_ID)) {
            int movieId = getArguments().getInt(AppExtras.ARGUMENT_MOVIE_ID);
            getPresenter().onSetMovieId(movieId);
        }

        initViews();
    }

    private void initViews() {
        toolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);
        toolbar.setNavigationOnClickListener(v -> getPresenter().onBackPressed());
    }

    ///////////////////////////////////////////////////////////////////////////
    // GETTERS
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Возвращает текущий презентер
     */
    @Override
    protected MovieDetailsPresenter getPresenter() {
        return movieDetailsPresenter;
    }

    ///////////////////////////////////////////////////////////////////////////
    // MVP
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public void setMovieData(MovieDetailsViewModel movieDetails) {
        collapsingToolbarLayout.setTitle(movieDetails.getTitle());
        imageLoader.setImageWithCallback(toolbarImage, movieDetails.getBackdropPath(), this);
        imageLoader.setImageFitCenter(imagePoster, movieDetails.getPosterPath());

        textReleaseDate.setText(movieDetails.getReleaseDate());
        textVoteAverage.setText(movieDetails.getVoteAverage());
        textRuntime.setText(movieDetails.getRuntime());
        text_overview.setText(movieDetails.getOverview());
    }

    ///////////////////////////////////////////////////////////////////////////
    // UI METHODS
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public void onImageLoadSuccess() {
        super.onHideLoading();
    }

    @Override
    public void onImageLoadFailed() {
        super.onHideLoading();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
