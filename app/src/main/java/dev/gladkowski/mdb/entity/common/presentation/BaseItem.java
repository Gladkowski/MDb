package dev.gladkowski.mdb.entity.common.presentation;

/**
 * Base item for all adapters
 */
public abstract class BaseItem {

    /**
     * Get view type of an list item
     *
     * @return ItemViewType that indicates how many columns should item fill
     */
    public abstract ItemViewType getItemViewType();

}
