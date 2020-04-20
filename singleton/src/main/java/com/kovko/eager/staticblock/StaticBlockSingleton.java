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
        } catch (DuplicateSingletonException e) {
            System.out.println("Exception has happened " + e);
        }
    }

    private StaticBlockSingleton() {
        if (instance!=null){
            throw new DuplicateSingletonException();
        }
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}
