package ws.ament.cdi.se.events;

import org.jboss.weld.executor.FixedThreadPoolExecutorServices;

import javax.enterprise.event.Event;
import javax.enterprise.event.NotificationOptions;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.util.concurrent.CompletionStage;

public class EventBootstrap {
    public static void main(String...args) throws Exception{
        try(SeContainer container = SeContainerInitializer.newInstance()
                .addPackages(Pojo.class)
                .disableDiscovery()
                .initialize()) {
            Event<Object> event = container.getBeanManager().getEvent();
            FixedThreadPoolExecutorServices executorServices = new FixedThreadPoolExecutorServices(2);
            event.fireAsync(new Pojo("this is asynchronous"),
                    NotificationOptions.ofExecutor(executorServices.getTaskExecutor()))
                    .whenCompleteAsync((pojo, throwable) -> event.fire(new Pojo(pojo.showName() + ", and now this is synchronous")));
            Thread.sleep(500L);
        }
    }
}
