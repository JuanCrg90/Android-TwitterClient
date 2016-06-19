package me.juancrg90.android.twitterclient.lib;

import me.juancrg90.android.twitterclient.lib.base.EventBus;

/**
 * Created by juancrg90.
 */
public class GreenRobotEventBus implements EventBus {
    org.greenrobot.eventbus.EventBus eventBus;

    public GreenRobotEventBus(org.greenrobot.eventbus.EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void register(Object subscriber) {
        eventBus.register(subscriber);
    }

    @Override
    public void unregister(Object subscriber) {
        eventBus.unregister(subscriber);

    }

    @Override
    public void post(Object event) {
        eventBus.post(event);
    }
}
