package me.juancrg90.android.twitterclient.images.di;

import javax.inject.Singleton;

import dagger.Component;
import me.juancrg90.android.twitterclient.lib.di.LibsModule;
import me.juancrg90.android.twitterclient.images.ImagesPresenter;
import me.juancrg90.android.twitterclient.images.ui.ImagesFragment;

/**
 * Created by juancrg90.
 */

@Singleton @Component(modules = {LibsModule.class, ImagesModule.class})
public interface ImagesComponent {
    void inject(ImagesFragment fragment);
    ImagesPresenter getPresenter();

}
