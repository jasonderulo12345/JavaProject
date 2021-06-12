package event;

import java.util.ArrayList;
import java.util.List;

public class EventBusImpl implements EventBus {
    private static final EventBusImpl eventBusImpl = new EventBusImpl();
    private List<Subscriber> subscribers;

    public EventBusImpl() {
        subscribers = new ArrayList<>();
    }

    public static EventBus getInstance() {
        return eventBusImpl;
    }

    @Override
    public void register(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void dispatch(Event event) {
        for (Subscriber subscriber : subscribers) {
            subscriber.handleEvent(event);
        }
    }

    @Override
    public List<Subscriber> getSubscribers() {
        return subscribers;
    }

}