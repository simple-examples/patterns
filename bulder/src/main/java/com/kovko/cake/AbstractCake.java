package com.kovko.cake;

/**
 * Author: eukovko
 * Date: 9/8/2020
 */
public abstract class AbstractCake {

    private String name;

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    void eatCake() {

        System.out.println("Mmmm... this is suck a tasty " + name);
    }

}
