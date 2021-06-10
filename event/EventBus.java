// MACAM OVER LAH PULAK 😭
// btw ni guna untuk presenter nanti
// saja nak cukupkan 3 attribute tu uhuks

package event;

import java.util.List;

public interface EventBus {
    void register(Subscriber subscriber);
    void dispatch(Event event);
    List<Subscriber> getSubscribers();
}