package me.juancrg90.android.twitterclient.hashtags;

import java.util.List;

import me.juancrg90.android.twitterclient.api.CustomTwitterApiClient;
import me.juancrg90.android.twitterclient.entities.Hashtag;
import me.juancrg90.android.twitterclient.entities.Image;
import me.juancrg90.android.twitterclient.hashtags.events.HashtagsEvent;
import me.juancrg90.android.twitterclient.lib.base.EventBus;

/**
 * Created by juancrg90.
 */
public class HashtagsRepositoryImpl implements HashtagsRepository {
    private EventBus eventBus;
    private CustomTwitterApiClient client;
    private final static int TWEET_COUNT = 100;

    public HashtagsRepositoryImpl(EventBus eventBus, CustomTwitterApiClient client) {
        this.eventBus = eventBus;
        this.client = client;
    }

    // TODO Implement gethashtags
    @Override
    public void getHashtags() {

    }

    private void post(List<Hashtag> items) {
        post(items, null);
    }

    private void post(String error) {
        post(null, error);
    }

    private void post(List<Hashtag> items, String error) {
        HashtagsEvent event = new HashtagsEvent();
        event.setError(error);
        event.setHashtags(items);
        eventBus.post(event);
    }
}
