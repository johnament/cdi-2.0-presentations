package ws.ament.cdi.se.async;

import ws.ament.cdi.se.events.Pojo;

import javax.enterprise.event.Event;
import javax.enterprise.event.NotificationOptions;
import javax.enterprise.event.ObservesAsync;
import javax.inject.Inject;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by johnament on 3/8/17.
 */
public class AsyncEvents {
    @Inject
    private Event<Pojo> pojoEvent;

    public void sender() {
        pojoEvent.fireAsync(new Pojo("pojo"), NotificationOptions.ofExecutor(new ForkJoinPool(2)));
    }

    public void asyncReceiver(@ObservesAsync Pojo pojo) {

    }
}
