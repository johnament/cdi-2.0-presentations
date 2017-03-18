package ws.ament.cdi.se.beans;

import javax.enterprise.inject.Vetoed;
import javax.inject.Inject;

@Vetoed
public class VetoedBean {
    @Inject
    private AppScopedBean appScopedBean;
    public String whatAmI() {
        return "dependent using "+appScopedBean.sayHello();
    }
}
