package ws.ament.cdi.se.extensions;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.Extension;

public class BeanConfigurator implements Extension {

    public void onBean(@Observes AfterBeanDiscovery afterBeanDiscovery) {
        afterBeanDiscovery.addBean()
                .produceWith(instance -> new Object())
                .destroyWith((o, cc) -> {})
                ;
    }
}
