package com.kovko.director;

import com.kovko.builder.CakeBuilder;
import com.kovko.cake.Cake;

/**
 * Author: eukovko
 * Date: 9/9/2020
 */
public class HoneyCakeDirector implements CakeDirector {

    private CakeBuilder cakeBuilder = new CakeBuilder();

    @Override
    public Cake create() {

        return cakeBuilder.name("Honey cake")
                .flour(200)
                .water(150)
                .eggs(4)
                .topping("honey")
                .build();
    }
}
