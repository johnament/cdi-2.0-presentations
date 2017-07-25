package ws.ament.cdi.se.events;

import javax.enterprise.event.Event;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.util.concurrent.CompletionStage;

public class ReactiveBootstrap {
    public static void main(String...args) throws Exception{
        try(SeContainer container = SeContainerInitializer.newInstance()
                .addPackages(Pojo.class)
                .disableDiscovery()
                .initialize()) {
            ReactiveEmitter emitter = container.select(ReactiveEmitter.class).get();
            Pojo reactive = emitter.send("reactive").block();
            System.out.println(reactive.showName());
        }
    }
}
