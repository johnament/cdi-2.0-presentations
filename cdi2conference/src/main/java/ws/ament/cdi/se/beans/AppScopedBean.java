package ws.ament.cdi.se.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.control.ActivateRequestContext;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

@ApplicationScoped
@ActivateRequestContext
public class AppScopedBean {
    @Inject
    private RequestScopedBean requestScopedBean;

    @Inject
    private Instance<RequestScopedBean> instance;

    public void boop() {
        instance
                .stream()
                .findFirst()
                .ifPresent(bean -> bean.sayHello());
    }

    public String sayHello() {
        return "the request scoped bean said "+requestScopedBean.sayHello();
    }

}
