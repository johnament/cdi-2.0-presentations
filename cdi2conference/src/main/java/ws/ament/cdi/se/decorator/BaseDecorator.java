package ws.ament.cdi.se.decorator;

import javax.enterprise.context.Dependent;

@Dependent
public class BaseDecorator implements SomeDecorator{
    @Override
    public String sayGreeting() {
        return "Hello";
    }
}
