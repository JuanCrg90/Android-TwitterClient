package me.juancrg90.android.twitterclient.hashtags.di;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Session;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.juancrg90.android.twitterclient.api.CustomTwitterApiClient;
import me.juancrg90.android.twitterclient.entities.Hashtag;
import me.juancrg90.android.twitterclient.entities.Image;
import me.juancrg90.android.twitterclient.hashtags.HashtagsInteractor;
import me.juancrg90.android.twitterclient.hashtags.HashtagsInteractorImpl;
import me.juancrg90.android.twitterclient.hashtags.HashtagsPresenter;
import me.juancrg90.android.twitterclient.hashtags.HashtagsPresenterImpl;
import me.juancrg90.android.twitterclient.hashtags.HashtagsRepository;
import me.juancrg90.android.twitterclient.hashtags.HashtagsRepositoryImpl;
import me.juancrg90.android.twitterclient.hashtags.ui.HashtagsView;
import me.juancrg90.android.twitterclient.hashtags.ui.adapters.HashtagsAdapter;
import me.juancrg90.android.twitterclient.images.ImagesInteractor;
import me.juancrg90.android.twitterclient.images.ImagesInteractorImpl;
import me.juancrg90.android.twitterclient.images.ImagesPresenter;
import me.juancrg90.android.twitterclient.images.ImagesPresenterImpl;
import me.juancrg90.android.twitterclient.images.ImagesRepository;
import me.juancrg90.android.twitterclient.images.ImagesRepositoryImpl;
import me.juancrg90.android.twitterclient.images.ui.ImagesView;
import me.juancrg90.android.twitterclient.hashtags.ui.adapters.OnItemClickListener;
import me.juancrg90.android.twitterclient.lib.base.EventBus;

/**
 * Created by juancrg90.
 */
@Module
public class HashtagsModule {
    private HashtagsView view;
    private OnItemClickListener clickListener;

    public HashtagsModule(HashtagsView view, OnItemClickListener clickListener) {
        this.view = view;
        this.clickListener = clickListener;
    }

    @Provides
    @Singleton
    HashtagsAdapter providesAdapter(List<Hashtag> dataset, OnItemClickListener clickListener) {
        return new HashtagsAdapter(dataset, clickListener);
    }

    @Provides
    @Singleton
    OnItemClickListener providesOnItemClickListener() {
        return this.clickListener;
    }

    @Provides
    @Singleton
    List<Hashtag> providesItemList() {
        return new ArrayList<Hashtag>();
    }


    @Provides
    @Singleton
    HashtagsPresenter HashtagsPresenter(HashtagsView view, EventBus eventBus, HashtagsInteractor interactor) {
        return new HashtagsPresenterImpl(view, eventBus, interactor);
    }

    @Provides
    @Singleton
    HashtagsView providesHashtagsView () {
        return this.view;
    }

    @Provides
    @Singleton
    HashtagsInteractor providesHashtagsInteractor(HashtagsRepository repository) {
        return new HashtagsInteractorImpl(repository);
    }

    @Provides
    @Singleton
    HashtagsRepository providesHashtagsRepository(EventBus eventBus, CustomTwitterApiClient client) {
        return new HashtagsRepositoryImpl(eventBus, client);
    }

    @Provides
    @Singleton
    CustomTwitterApiClient providesCustomTwitterApiClient(Session session) {
        return new CustomTwitterApiClient(session);
    }

    @Provides
    @Singleton
    Session providesTwitterSession() {
        return Twitter.getSessionManager().getActiveSession();
    }

}
