package me.juancrg90.android.twitterclient.images;

/**
 * Created by juancrg90.
 */
public class ImagesInteractorImpl implements ImagesInteractor {
    private ImagesRepository repository;

    public ImagesInteractorImpl(ImagesRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        repository.getImages();
    }
}
