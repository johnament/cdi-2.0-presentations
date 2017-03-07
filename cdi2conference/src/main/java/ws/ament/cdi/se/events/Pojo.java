package ws.ament.cdi.se.events;

/**
 * Created by johnament on 3/6/17.
 */
public class Pojo {
    private final String name;

    public Pojo(String name) {
        this.name = name;
    }

    public String showName() {
        return name;
    }
}
