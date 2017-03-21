package ws.ament.cdi.se;

import ws.ament.cdi.se.beans.AppScopedBean;
import ws.ament.cdi.se.beans.RequestScopedBean;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class RegistrationBootstrap {
    public static void main(String...args) {
        try(SeContainer container = SeContainerInitializer.newInstance()
                .addPackages(RequestScopedBean.class)
                .disableDiscovery()
                .initialize()) {
            AppScopedBean appScopedBean = container.select(AppScopedBean.class).get();
            System.out.println("It says "+appScopedBean.sayHello());
        }
    }
}
