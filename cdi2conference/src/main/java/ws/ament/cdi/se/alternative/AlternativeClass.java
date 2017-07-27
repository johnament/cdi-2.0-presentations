package ws.ament.cdi.se.alternative;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Alternative;

@Alternative
@ApplicationScoped
@Priority(500)
public class AlternativeClass extends BaseClass {
    public String sayHello() {
        return "I'm the alternative";
    }

    public void init(@Observes @Initialized(ApplicationScoped.class) Object obj) {
        System.out.println("Init in alternative class");
    }
}
