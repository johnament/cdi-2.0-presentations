package ws.ament.cdi.se.events;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class SyncEventReceiver {
    private static final Logger logger = LogManager.getLogger(SyncEventReceiver.class);
    public void onReception(@Observes Pojo pojo) {
        logger.info(pojo.showName());
    }
}
