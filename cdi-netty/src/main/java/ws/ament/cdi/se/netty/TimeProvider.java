package ws.ament.cdi.se.netty;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class TimeProvider {
    private long currentTime;

    @PostConstruct
    public void init() {
        this.currentTime = System.currentTimeMillis();
    }
    public long getCurrentTime() {
        return currentTime;
    }
}
