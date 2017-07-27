package ws.ament.cdi.se.events;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Named;

@ApplicationScoped
public class SyncEventReceiver {
    private static final Logger logger = LogManager.getLogger(SyncEventReceiver.class);
    public void onReception(@Observes @Named("one") Pojo pojo) {
        logger.info("1" + pojo.showName());
    }

    public void onReception2(@Observes @Named("two") Pojo pojo) {
        logger.info("2" + pojo.showName());
    }
}
