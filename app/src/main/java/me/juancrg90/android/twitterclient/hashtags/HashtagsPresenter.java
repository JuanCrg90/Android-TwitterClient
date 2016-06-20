package me.juancrg90.android.twitterclient.hashtags;

import me.juancrg90.android.twitterclient.hashtags.events.HashtagsEvent;
import me.juancrg90.android.twitterclient.images.events.ImagesEvent;

/**
 * Created by juancrg90.
 */
public interface HashtagsPresenter {
    void onResume();
    void onPause();
    void onDestroy();
    void getHashtagTweets();
    void onEventMainThread(HashtagsEvent event);
}
