package me.juancrg90.android.twitterclient.images.di;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Session;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.juancrg90.android.twitterclient.api.CustomTwitterApiClient;
import me.juancrg90.android.twitterclient.entities.Image;
import me.juancrg90.android.twitterclient.images.ImagesInteractor;
import me.juancrg90.android.twitterclient.images.ImagesInteractorImpl;
import me.juancrg90.android.twitterclient.images.ImagesPresenter;
import me.juancrg90.android.twitterclient.images.ImagesPresenterImpl;
import me.juancrg90.android.twitterclient.images.ImagesRepository;
import me.juancrg90.android.twitterclient.images.ImagesRepositoryImpl;
import me.juancrg90.android.twitterclient.images.ui.adapters.ImagesAdapter;
import me.juancrg90.android.twitterclient.images.ui.adapters.OnItemClickListener;
import me.juancrg90.android.twitterclient.images.ui.ImagesView;
import me.juancrg90.android.twitterclient.lib.base.EventBus;
import me.juancrg90.android.twitterclient.lib.base.ImageLoader;

/**
 * Created by juancrg90.
 */
@Module
public class ImagesModule {
    private ImagesView view;
    private OnItemClickListener clickListener;

    public ImagesModule(ImagesView view, OnItemClickListener clickListener) {
        this.view = view;
        this.clickListener = clickListener;
    }

    @Provides
    @Singleton
    ImagesAdapter providesAdapter(List<Image> dataset, ImageLoader imageLoader, OnItemClickListener clickListener) {
        return new ImagesAdapter(dataset, imageLoader, clickListener);
    }

    @Provides
    @Singleton
    OnItemClickListener providesOnItemClickListener() {
        return this.clickListener;
    }

    @Provides
    @Singleton
    List<Image> providesItemList() {
        return new ArrayList<Image>();
    }


    @Provides
    @Singleton
    ImagesPresenter providesImagesPresenter(ImagesView view, EventBus eventBus, ImagesInteractor interactor) {
        return new ImagesPresenterImpl(view, eventBus, interactor);
    }

    @Provides
    @Singleton
    ImagesView providesImagesView() {
        return this.view;
    }

    @Provides
    @Singleton
    ImagesInteractor providesImagesInteractor(ImagesRepository repository) {
        return new ImagesInteractorImpl(repository);
    }

    @Provides
    @Singleton
    ImagesRepository providesImagesRepository(EventBus eventBus, CustomTwitterApiClient client) {
        return new ImagesRepositoryImpl(eventBus, client);
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
