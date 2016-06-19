package me.juancrg90.android.twitterclient.lib;

import android.widget.ImageView;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import me.juancrg90.android.twitterclient.lib.base.ImageLoader;

/**
 * Created by juancrg90.
 */
public class GlideImageLoader implements ImageLoader {

    public GlideImageLoader(RequestManager glideRequestManager) {
        this.glideRequestManager = glideRequestManager;
    }

    private RequestManager glideRequestManager;
    @Override
    public void load(ImageView imageView, String URL) {

        glideRequestManager
                .load(URL)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .override(600, 400)
                .into(imageView);
    }
}
