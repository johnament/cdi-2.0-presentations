package ws.ament.cdi.se.mpconfig;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;

public class Main {
    public static void main(String[] args) {
        Config config = ConfigProvider.getConfig();
        System.out.println(config.getValue("PATH", String.class));
    }
}
