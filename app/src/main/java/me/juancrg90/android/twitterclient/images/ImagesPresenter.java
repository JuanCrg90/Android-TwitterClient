package me.juancrg90.android.twitterclient.images;

import me.juancrg90.android.twitterclient.images.events.ImagesEvent;

/**
 * Created by juancrg90.
 */
public interface ImagesPresenter {
    void onResume();
    void onPause();
    void onDestroy();
    void getImageTweets();
    void onEventMainThread(ImagesEvent event);
}
