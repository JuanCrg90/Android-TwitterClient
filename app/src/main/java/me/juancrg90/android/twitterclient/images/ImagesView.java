package me.juancrg90.android.twitterclient.images;

import java.util.List;

import me.juancrg90.android.twitterclient.entities.Image;

/**
 * Created by juancrg90.
 */
public interface ImagesView {
    void showElements();
    void hideElements();
    void showProgress();
    void hideProgress();

    void onError(String error);
    void setContent(List<Image> items);
}
