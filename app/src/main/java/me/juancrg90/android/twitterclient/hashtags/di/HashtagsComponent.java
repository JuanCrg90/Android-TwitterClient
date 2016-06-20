package me.juancrg90.android.twitterclient.hashtags.di;

import javax.inject.Singleton;

import dagger.Component;
import me.juancrg90.android.twitterclient.hashtags.ui.HashtagsFragment;
import me.juancrg90.android.twitterclient.images.di.ImagesModule;
import me.juancrg90.android.twitterclient.lib.di.LibsModule;

/**
 * Created by juancrg90.
 */

@Singleton @Component(modules = {LibsModule.class, HashtagsModule.class})
public interface HashtagsComponent {
    void inject(HashtagsFragment fragment);
}
