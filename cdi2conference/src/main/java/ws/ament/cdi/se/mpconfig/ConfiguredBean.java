package ws.ament.cdi.se.mpconfig;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ConfiguredBean {
    @Inject
    @ConfigProperty(name="PATH")
    private String path;

    public String getPath() {
        return path;
    }
}
