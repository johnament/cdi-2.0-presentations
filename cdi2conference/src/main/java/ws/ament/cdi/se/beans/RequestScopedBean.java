package ws.ament.cdi.se.beans;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class RequestScopedBean {
    public String sayHello() {
        return "hello";
    }
}
