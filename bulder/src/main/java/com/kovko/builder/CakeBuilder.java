package com.kovko.builder;

import com.kovko.cake.Cake;

/**
 * Author: eukovko
 * Date: 9/9/2020
 */
public class CakeBuilder {

    private String name = "";
    private int flour;
    private int water;
    private int eggs;
    private String topping = "";

    private Cake cake;

    public CakeBuilder name(String name) {
        this.name = name;
        return this;
    }

    public CakeBuilder flour(int flour) {
        this.flour = flour;
        return this;
    }

    public CakeBuilder water(int water) {
        this.water = water;
        return this;
    }

    public CakeBuilder eggs(int eggs) {
        this.eggs = eggs;
        return this;
    }

    public CakeBuilder topping(String topping) {
        this.topping = topping;
        return this;
    }

    public void reset(){
        name = "";
        flour = 0;
        water = 0;
        eggs = 0;
        topping = "";
    }
    public Cake build() {
        Cake cake = new Cake(name, flour, water, eggs, topping);
        reset();
        return cake;
    }
}
