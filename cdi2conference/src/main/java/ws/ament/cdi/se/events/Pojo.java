package ws.ament.cdi.se.events;

public class Pojo {
    private final String name;

    public Pojo(String name) {
        this.name = name;
    }

    public String showName() {
        return name;
    }
}
