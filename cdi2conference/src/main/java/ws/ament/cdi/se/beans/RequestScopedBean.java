package ws.ament.cdi.se.beans;

import javax.enterprise.context.RequestScoped;

/**
 * Created by johnament on 3/6/17.
 */
@RequestScoped
public class RequestScopedBean {
    public String sayHello() {
        return "hello";
    }
}
