package com.kovko.eager.simple;

/**
 * Author: eukovko
 * Date: 4/18/2020
 */
public class SimpleSingleton {

    private static final SimpleSingleton instance = new SimpleSingleton();

    private SimpleSingleton() {
    }

    public static SimpleSingleton getInstance() {
        return instance;
    }
}
