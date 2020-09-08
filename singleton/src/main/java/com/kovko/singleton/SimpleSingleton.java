package com.kovko.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Objects;

/**
 * Author: eukovko
 * Date: 4/18/2020
 */
public class SimpleSingleton implements Serializable {

    private transient String singletonName;
    private static final SimpleSingleton instance = new SimpleSingleton();

    private SimpleSingleton() {
        if (instance != null) {
            throw new IllegalStateException("Cannot create another instance of the singleton");
        }
    }

    public static SimpleSingleton getInstance() {
        return instance;
    }

    public String getSingletonName() {
        return singletonName;
    }

    public void setSingletonName(String singletonName) {
        this.singletonName = singletonName;
    }

    @Override
    public String toString() {
        return "SimpleSingleton{" +
                "singletonName='" + singletonName + '\'' +
                '}';
    }

    private Object readResolve() throws ObjectStreamException {
        return instance;
    }
}
