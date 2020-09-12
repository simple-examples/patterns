package com.kovko.director;

import com.kovko.builder.CakeBuilder;
import com.kovko.cake.Cake;

/**
 * Author: eukovko
 * Date: 9/9/2020
 */
public class ChocolateCakeDirector implements CakeDirector {

    private CakeBuilder cakeBuilder = new CakeBuilder();

    @Override
    public Cake create() {

        return cakeBuilder.name("Chocolate cake")
                .flour(300)
                .water(200)
                .eggs(3)
                .topping("chocolate")
                .build();
    }
}
