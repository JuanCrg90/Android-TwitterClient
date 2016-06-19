package me.juancrg90.android.twitterclient;

import android.app.Application;
import android.support.v4.app.Fragment;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import io.fabric.sdk.android.Fabric;
import me.juancrg90.android.twitterclient.images.di.DaggerImagesComponent;
import me.juancrg90.android.twitterclient.images.di.ImagesComponent;
import me.juancrg90.android.twitterclient.images.di.ImagesModule;
import me.juancrg90.android.twitterclient.images.ui.ImagesView;
import me.juancrg90.android.twitterclient.images.ui.adapters.OnItemClickListener;
import me.juancrg90.android.twitterclient.lib.di.LibsModule;


/**
 * Created by juancrg90
 */
public class TwitterClientApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initFabric();
    }

    private void initFabric() {
        TwitterAuthConfig authConfig = new TwitterAuthConfig(BuildConfig.TWITTER_KEY, BuildConfig.TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
    }

    public ImagesComponent getImagesComponent(Fragment fragment, ImagesView view, OnItemClickListener clickListener) {
        return DaggerImagesComponent
                .builder()
                .libsModule(new LibsModule(fragment))
                .imagesModule(new ImagesModule(view, clickListener))
                .build();
    }
}
