package ws.ament.cdi.se.events;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.ObservesAsync;

@ApplicationScoped
public class AsyncEventReceiver {
    private static final Logger logger = LogManager.getLogger(AsyncEventReceiver.class);
    public void onReception(@ObservesAsync Pojo pojo) {
        logger.info(pojo.showName());
        try {
            Thread.sleep(400l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void onReception2(@ObservesAsync Pojo pojo) {
        logger.info(pojo.showName());
        try {
            Thread.sleep(400l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void onReception3(@ObservesAsync Pojo pojo) {
        logger.info(pojo.showName());
        try {
            Thread.sleep(400l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
