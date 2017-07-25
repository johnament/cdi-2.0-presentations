package ws.ament.cdi.se.async;

import javax.enterprise.inject.se.SeContainer;

import static javax.enterprise.inject.se.SeContainerInitializer.newInstance;

public class AsyncBootstrap {
    public static void main(String...args) {
        SeContainer container = newInstance()
                .disableDiscovery()
                .addPackages(AsyncBootstrap.class)
                .initialize();
        AsyncEvents asyncEvents = container.select(AsyncEvents.class).get();
        asyncEvents.sender("some event");
    }
}
