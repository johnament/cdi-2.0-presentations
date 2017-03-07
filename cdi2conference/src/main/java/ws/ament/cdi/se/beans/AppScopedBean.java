package ws.ament.cdi.se.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.control.ActivateRequestContext;
import javax.inject.Inject;

/**
 * Created by johnament on 3/6/17.
 */
@ApplicationScoped
@ActivateRequestContext
public class AppScopedBean {
    @Inject
    private RequestScopedBean requestScopedBean;

    public String sayHello() {
        return "the request scoped bean said "+requestScopedBean.sayHello();
    }

}
