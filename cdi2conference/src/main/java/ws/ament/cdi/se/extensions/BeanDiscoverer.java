package ws.ament.cdi.se.extensions;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessBean;
import javax.inject.Singleton;

public class BeanDiscoverer implements Extension {
    public void onBeans(@Observes ProcessBean<?> pb) {

    }

    @Singleton
    public static class Producers {

    }

    public static void main(String...args) {
        final SeContainer initialize = SeContainerInitializer.newInstance()
                .initialize();
        initialize.select(Producers.class).is
        final Producers producers = initialize.select(Producers.class).get();
        assert producers == null;
        initialize.close();
    }
}
