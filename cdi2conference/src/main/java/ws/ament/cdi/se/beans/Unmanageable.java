package ws.ament.cdi.se.beans;

import javax.enterprise.inject.spi.Unmanaged;

public class Unmanageable<T> implements AutoCloseable{

    private final Unmanaged.UnmanagedInstance<T> instance;

    public Unmanageable(Class<T> clazz) {
        this.instance = new Unmanaged<T>(clazz).newInstance();
        this.instance
                .produce()
                .inject()
                .postConstruct();
    }

    public T get() {
        return this.instance.get();
    }

    @Override
    public void close() {
        this.instance.preDestroy().dispose();
    }
}
