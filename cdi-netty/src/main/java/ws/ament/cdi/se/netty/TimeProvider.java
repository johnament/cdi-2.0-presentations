package ws.ament.cdi.se.netty;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class TimeProvider {
    public long getCurrentTime() {
        return System.currentTimeMillis();
    }
}
