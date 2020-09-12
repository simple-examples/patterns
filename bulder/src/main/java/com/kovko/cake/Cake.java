package com.kovko.cake;

/**
 * Author: eukovko
 * Date: 9/8/2020
 */
public class Cake {

    private final String name;
    private final int flour;
    private final int water;
    private final int eggs;
    private final String topping;

    public Cake(String name, int flour, int water, int eggs, String topping) {
        this.name = name;
        this.flour = flour;
        this.water = water;
        this.eggs = eggs;
        this.topping = topping;
    }
}
