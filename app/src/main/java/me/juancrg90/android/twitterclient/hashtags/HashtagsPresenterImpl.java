package me.juancrg90.android.twitterclient.hashtags;

import org.greenrobot.eventbus.Subscribe;

import me.juancrg90.android.twitterclient.hashtags.events.HashtagsEvent;
import me.juancrg90.android.twitterclient.hashtags.ui.HashtagsView;
import me.juancrg90.android.twitterclient.lib.base.EventBus;

/**
 * Created by juancrg90.
 */
public class HashtagsPresenterImpl implements HashtagsPresenter {
    HashtagsView view;
    EventBus eventBus;
    HashtagsInteractor interactor;

    public HashtagsPresenterImpl(HashtagsView view, EventBus eventBus, HashtagsInteractor interactor) {
        this.view = view;
        this.eventBus = eventBus;
        this.interactor = interactor;
    }

    @Override
    public void onResume() {
        eventBus.register(this);
    }

    @Override
    public void onPause() {
        eventBus.unregister(this);

    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void getHashtagTweets() {

        if(view != null) {
            view.hideHashtagsTweets();
            view.showProgress();
        }
        interactor.execute();
    }

    @Override
    @Subscribe
    public void onEventMainThread(HashtagsEvent event) {
        String errorMsg = event.getError();

        if(view != null) {
            view.showHashtagsTweets();
            view.hideProgress();

            if(errorMsg != null) {
                view.onError(errorMsg);
            } else {
                view.setContent(event.getHashtags());
            }
        }

    }
}
