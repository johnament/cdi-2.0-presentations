package ws.ament.cdi.se.async;

import ws.ament.cdi.se.events.Pojo;

import javax.enterprise.event.Event;
import javax.enterprise.event.NotificationOptions;
import javax.enterprise.event.ObservesAsync;
import javax.inject.Inject;
import java.util.concurrent.ForkJoinPool;

public class AsyncEvents {
    @Inject
    private Event<Pojo> pojoEvent;

    public void sender(String name) {
        pojoEvent.fireAsync(new Pojo(name), NotificationOptions.ofExecutor(new ForkJoinPool(2)));
    }

    public void asyncReceiver(@ObservesAsync Pojo pojo) {
        System.out.println("On thread "+Thread.currentThread().getName()+" received pojo "+pojo.showName());
    }
}
