package com.kovko.factory;

import com.kovko.builder.CakeBuilder;
import com.kovko.cake.Cake;

/**
 * Author: eukovko
 * Date: 9/9/2020
 */
public class CakeFactory {

    public Cake createChocolateCake(CakeBuilder builder) {

        builder.reset();
        return builder.name("Chocolate cake")
                .flour(300)
                .water(200)
                .eggs(3)
                .topping("chocolate")
                .build();
    }

    public Cake createHoneyCake(CakeBuilder builder) {

        builder.reset();
        return builder.name("Honey cake")
                .flour(200)
                .water(150)
                .eggs(4)
                .topping("honey")
                .build();
    }
}
