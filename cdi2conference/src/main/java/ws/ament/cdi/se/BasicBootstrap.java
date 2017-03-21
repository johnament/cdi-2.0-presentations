package ws.ament.cdi.se;

import ws.ament.cdi.se.beans.AppScopedBean;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class BasicBootstrap {
    public static void main(String...args) {
        try(SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            AppScopedBean appScopedBean = container.select(AppScopedBean.class).get();
            System.out.println("It says "+appScopedBean.sayHello());
        }
    }
}
