package dev.gladkowski.mdb.presentation.movies.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dev.gladkowski.mdb.R;
import dev.gladkowski.mdb.entity.common.presentation.BaseItem;
import dev.gladkowski.mdb.entity.movies.presentation.MovieViewModel;
import dev.gladkowski.mdb.presentation.movies.adapter.callback.MovieItemCallback;
import dev.gladkowski.mdb.utils.imageloader.ImageLoader;


/**
 * Delegate with movie item
 */
public class MovieAdapterDelegate extends AdapterDelegate<List<BaseItem>> {

    @NonNull
    private MovieItemCallback movieItemCallback;
    @NonNull
    private ImageLoader imageLoader;

    MovieAdapterDelegate(@NonNull MovieItemCallback movieItemCallback,
                         @NonNull ImageLoader imageLoader) {
        this.movieItemCallback = movieItemCallback;
        this.imageLoader = imageLoader;
    }

    @Override
    public boolean isForViewType(@NonNull List items, int position) {
        return items.get(position) instanceof MovieViewModel;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View item = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull List<BaseItem> items,
                                 int position,
                                 @NonNull RecyclerView.ViewHolder holder,
                                 @Nullable List<Object> payloads) {

        MovieAdapterDelegate.ViewHolder viewHolder = (MovieAdapterDelegate.ViewHolder) holder;
        MovieViewModel viewModel = (MovieViewModel) items.get(position);

        viewHolder.setItem(viewModel);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.container)
        ConstraintLayout container;
        @BindView(R.id.image_poster)
        ImageView imageView;
        @BindView(R.id.text_title)
        TextView textTitle;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void setItem(MovieViewModel item) {
            imageLoader.setImage(imageView, item.getPosterPath());
            textTitle.setText(item.getTitle());
            container.setOnClickListener(view -> movieItemCallback.onItemClick(item.getId()));
        }
    }
}
