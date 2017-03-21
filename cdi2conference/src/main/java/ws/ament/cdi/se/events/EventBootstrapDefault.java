package ws.ament.cdi.se.events;

import javax.enterprise.event.Event;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.util.concurrent.CompletionStage;

public class EventBootstrapDefault {
    public static void main(String...args) throws Exception{
        try(SeContainer container = SeContainerInitializer.newInstance()
                .addPackages(Pojo.class)
                .disableDiscovery()
                .initialize()) {
            Event<Object> event = container.getBeanManager().getEvent();
            CompletionStage<Pojo> completionStage = event.fireAsync(new Pojo("this is asynchronous"));
            completionStage.whenCompleteAsync((pojo, throwable) -> event.fire(new Pojo(pojo.showName() + ", and now this is synchronous")));
            Thread.sleep(500L);
        }
    }
}
