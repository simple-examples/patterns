package com.kovko.specification;

import com.kovko.builder.CakeBuilder;
import com.kovko.cake.Cake;

/**
 * Author: eukovko
 * Date: 9/9/2020
 */
public class HoneyCakeSpecification implements CakeSpecification {

    private final CakeBuilder cakeBuilder;

    public HoneyCakeSpecification(CakeBuilder cakeBuilder) {
        this.cakeBuilder = cakeBuilder;
    }

    @Override
    public Cake buildCake() {

        return cakeBuilder.name("Honey cake")
                .flour(200)
                .water(150)
                .eggs(4)
                .topping("honey")
                .build();
    }
}
