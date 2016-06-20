package me.juancrg90.android.twitterclient.hashtags;

/**
 * Created by juancrg90.
 */
public class HashtagsInteractorImpl implements HashtagsInteractor {
    HashtagsRepository repository;

    public HashtagsInteractorImpl(HashtagsRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        repository.getHashtags();
    }
}
