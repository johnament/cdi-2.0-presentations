package ws.ament.cdi.se.decorator;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
@Priority(500)
public class DelegatingDecorator implements SomeDecorator{
    @Inject
    @Delegate
    @Any
    private SomeDecorator someDecorator;

    @Override
    public String sayGreeting() {
        return "Even though the base said "+someDecorator.sayGreeting()+" I am saying good bye";
    }
}
