package dev.gladkowski.mdb.presentation.movies.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dev.gladkowski.mdb.R;
import dev.gladkowski.mdb.entity.common.presentation.BaseItem;
import dev.gladkowski.mdb.entity.common.presentation.ProgressItemViewModel;


/**
 * Delegate with loading spinner item
 */
public class ProgressItemAdapterDelegate extends AdapterDelegate<List<BaseItem>> {

    @Override
    protected boolean isForViewType(@NonNull List<BaseItem> items, int position) {
        return items.get(position) instanceof ProgressItemViewModel;
    }

    @NonNull
    @Override
    protected RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_progress, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull List<BaseItem> items, int position,
                                    @NonNull RecyclerView.ViewHolder holder,
                                    @NonNull List<Object> payloads) {
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.progress_bar)
        ProgressBar progressBar;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
