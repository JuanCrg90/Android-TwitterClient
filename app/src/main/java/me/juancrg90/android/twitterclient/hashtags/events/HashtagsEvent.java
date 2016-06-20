package me.juancrg90.android.twitterclient.hashtags.events;

import java.util.List;

import me.juancrg90.android.twitterclient.entities.Hashtag;

/**
 * Created by juancrg90.
 */
public class HashtagsEvent {
    private String error;
    private List<Hashtag> hashtags;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }


    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }
}
