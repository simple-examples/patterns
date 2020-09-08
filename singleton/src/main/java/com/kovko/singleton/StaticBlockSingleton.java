package com.kovko.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Objects;

/**
 * Author: eukovko
 * Date: 4/18/2020
 */
public class StaticBlockSingleton implements Serializable {

    private String singletonName;
    private static final StaticBlockSingleton instance;

    // Static block is useful when a constructor throws a checked exception
    // which has to be handled during creation
    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
    }

    private StaticBlockSingleton() throws IllegalAccessException {
        if (instance != null) {
            throw new IllegalAccessException("Cannot create another instance of the singleton");
        }
    }

    public static StaticBlockSingleton getInstance() {
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
        return "StaticBlockSingleton{" +
                "singletonName='" + singletonName + '\'' +
                '}';
    }

    private Object readResolve() throws ObjectStreamException {
        return instance;
    }
}
