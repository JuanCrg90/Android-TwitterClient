package me.juancrg90.android.twitterclient.hashtags.ui;

import java.util.List;

import me.juancrg90.android.twitterclient.entities.Hashtag;

/**
 * Created by juancrg90.
 */
public interface HashtagsView {
    void showHashtagsTweets();
    void hideHashtagsTweets();
    void showProgress();
    void hideProgress();

    void onError(String error);
    void setContent(List<Hashtag> items);
}
