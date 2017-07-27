package ws.ament.cdi.se.alternative;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class AlternativeMain {
    public static void main(String...args) {
        try(SeContainer container = SeContainerInitializer.newInstance().disableDiscovery().addPackages(true, AlternativeMain.class).initialize()) {
            BaseClass baseClass = container.select(BaseClass.class).get();
            System.out.println(baseClass.sayHello());
        }
    }
}
