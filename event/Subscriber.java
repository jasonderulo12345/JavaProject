package event;

public interface Subscriber {
    void handleEvent(Event event);
}
