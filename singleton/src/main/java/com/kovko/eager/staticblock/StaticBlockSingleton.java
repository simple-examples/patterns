package com.kovko.eager.staticblock;

/**
 * Author: eukovko
 * Date: 4/18/2020
 */
public class StaticBlockSingleton {

    private static StaticBlockSingleton instance;

    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            System.out.println("Exception has happened");
        }
    }

    private StaticBlockSingleton() {
    }
}
