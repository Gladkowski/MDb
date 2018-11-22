package dev.gladkowski.mdb.presentation.movies.adapter;

import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter;

import java.util.ArrayList;
import java.util.List;

import dev.gladkowski.mdb.entity.common.presentation.BaseItem;
import dev.gladkowski.mdb.entity.common.presentation.ProgressItemViewModel;
import dev.gladkowski.mdb.entity.movies.presentation.BaseMovieItem;
import dev.gladkowski.mdb.presentation.movies.adapter.callback.MovieItemCallback;
import dev.gladkowski.mdb.utils.imageloader.ImageLoader;


/**
 * Adapter for list of movies
 */
public class MoviesAdapter extends ListDelegationAdapter<List<BaseItem>> {

    private ProgressItemViewModel progressItem;

    public MoviesAdapter(MovieItemCallback movieItemCallback, ImageLoader imageLoader) {
        delegatesManager.addDelegate(new MovieAdapterDelegate(movieItemCallback, imageLoader));
        delegatesManager.addDelegate(new ProgressItemAdapterDelegate());

        progressItem = new ProgressItemViewModel();

        setItems(new ArrayList<>());
    }

    /**
     * Put items to the list
     */
    public void addItems(List<BaseMovieItem> movieItems) {
        items.clear();
        items.addAll(movieItems);
        this.notifyDataSetChanged();
    }

    /**
     * Add more items
     */
    public void addMoreItems(List<BaseMovieItem> baseItems) {
        items.addAll(baseItems);
        notifyItemChanged(getItemCount());
    }

    /**
     * Clear list
     */
    public void clearList() {
        items.clear();
        notifyDataSetChanged();
    }

    /**
     * Show loading spinner in the end of list
     */
    public void showPageLoading() {
        if (!items.contains(progressItem)) {
            items.add(progressItem);
            notifyItemChanged(items.size() - 1);
        }
    }

    /**
     * Hide loading spinner in the end of list
     */
    public void hidePageLoading() {
        if (items.contains(progressItem)) {
            items.remove(progressItem);
            notifyItemRemoved(items.size());
        }
    }

    /**
     * Get item object by it's position in list
     */
    public BaseItem getItemByPosition(int position) {
        return items.get(position);
    }
}
