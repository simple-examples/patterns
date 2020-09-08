package com.kovko.singleton;

/**
 * Author: eukovko
 * Date: 4/18/2020
 */
public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {
        if (instance != null) {
            throw new IllegalStateException("Cannot create another instance of the singleton");
        }
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
