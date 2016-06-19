package me.juancrg90.android.twitterclient.lib.base;

/**
 * Created by juancrg90.
 */
public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}
