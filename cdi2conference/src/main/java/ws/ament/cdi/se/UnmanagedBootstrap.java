package ws.ament.cdi.se;

import ws.ament.cdi.se.beans.VetoedBean;
import ws.ament.cdi.se.beans.Unmanageable;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class UnmanagedBootstrap {
    public static void main(String...args) {
        try(SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            try(Unmanageable<VetoedBean> unmanageable = new Unmanageable<>(VetoedBean.class)) {
                System.out.println(unmanageable.get().whatAmI());
            }
        }
    }
}
