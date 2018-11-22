package dev.gladkowski.mdb.utils.imageloader;

import android.widget.ImageView;

import dev.gladkowski.mdb.utils.imageloader.glide.ImageLoaderCallback;


/**
 * Load image into ImageView
 */
public interface ImageLoader {

    /**
     * Set image with callback
     */
    void setImageWithCallback(ImageView imageView, String url, ImageLoaderCallback callback);

    /**
     * Set image
     */
    void setImage(ImageView imageView, String url);

    /**
     * Clear image
     */
    void clearImage(ImageView imageView);
}
