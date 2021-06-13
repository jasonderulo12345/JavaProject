package event;

import java.util.List;

public interface EventBus {
    void register(Subscriber subscriber);
    void dispatch(Event event);
    List<Subscriber> getSubscribers();
}