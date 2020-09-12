package com.kovko.specification;

import com.kovko.builder.CakeBuilder;
import com.kovko.cake.Cake;

/**
 * Author: eukovko
 * Date: 9/9/2020
 */
public class ChocolateCakeSpecification implements CakeSpecification {

    private final CakeBuilder cakeBuilder;

    public ChocolateCakeSpecification(CakeBuilder cakeBuilder) {
        this.cakeBuilder = cakeBuilder;
    }

    @Override
    public Cake buildCake() {

        return cakeBuilder.name("Chocolate cake")
                .flour(300)
                .water(200)
                .eggs(3)
                .topping("chocolate")
                .build();
    }
}
