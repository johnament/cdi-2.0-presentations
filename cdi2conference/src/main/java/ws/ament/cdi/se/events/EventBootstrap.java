package ws.ament.cdi.se.events;

import org.jboss.weld.executor.FixedThreadPoolExecutorServices;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.NotificationOptions;
import javax.enterprise.inject.Stereotype;
import javax.enterprise.inject.literal.NamedLiteral;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Named;

@EventBootstrap.Bootstrapper
public class EventBootstrap {
    public static void main(String...args) throws Exception{
        try(SeContainer container = SeContainerInitializer.newInstance()
                .addPackages(Pojo.class)
                .disableDiscovery()
                .initialize()) {
            EventBootstrap eventBootstrap = container.select(EventBootstrap.class).get();
            eventBootstrap.doHello();
            Event<Object> event = container.getBeanManager().getEvent();
            FixedThreadPoolExecutorServices executorServices = new FixedThreadPoolExecutorServices(2);
            event.fireAsync(new Pojo("this is asynchronous"),
                    NotificationOptions.ofExecutor(executorServices.getTaskExecutor()))
                    .whenCompleteAsync((pojo, throwable) -> event
                            .select(NamedLiteral.of("one"))
                            .fire(new Pojo(pojo.showName() + ", and now this is synchronous")));
            Thread.sleep(5000L);
        }
    }
    public String doHello() {
        return "hello";
    }
    @Stereotype
    @RequestScoped
    @Named
    public @interface Bootstrapper {

    }
}


