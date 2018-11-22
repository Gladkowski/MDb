package dev.gladkowski.mdb.entity.common.presentation;


/**
 * Visual class for displaying progress in RecyclerView
 */
public class ProgressItemViewModel extends BaseItem {

    @Override
    public ItemViewType getItemViewType() {
        return ItemViewType.HEADER;
    }
}
