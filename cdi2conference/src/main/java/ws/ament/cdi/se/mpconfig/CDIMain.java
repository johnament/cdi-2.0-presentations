package ws.ament.cdi.se.mpconfig;

import org.eclipse.microprofile.config.Config;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class CDIMain {
    public static void main(String[] args) {
        try(SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            ConfiguredBean configuredBean = container.select(ConfiguredBean.class).get();
            System.out.println("Discovered path: "+configuredBean.getPath());

            Config config = container.select(Config.class).get();
            System.out.println("All properties "+config.getPropertyNames());
        }
    }
}
