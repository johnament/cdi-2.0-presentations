package ws.ament.cdi.se.events;

import reactor.core.publisher.Mono;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@ApplicationScoped
public class ReactiveEmitter {
    @Inject
    private Event<Pojo> event;

    public Mono<Pojo> send(String name) {
        return Mono.fromCompletionStage(event.fireAsync(new Pojo(name)));
    }
}
