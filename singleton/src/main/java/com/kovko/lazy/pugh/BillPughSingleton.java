package com.kovko.lazy.pugh;

/**
 * Author: eukovko
 * Date: 4/18/2020
 */
public class BillPughSingleton {

    private BillPughSingleton() {
    }

    private static class SingletonHolder {
        private static final BillPughSingleton instance = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance(){
        return SingletonHolder.instance;
    }

}
