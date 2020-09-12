package com.kovko.director;

import com.kovko.cake.Cake;
import com.kovko.specification.CakeSpecification;

/**
 * Author: eukovko
 * Date: 9/9/2020
 */
public class CakeSpecificationDirector {

    public Cake createCake(CakeSpecification specification){

        return specification.buildCake();
    }
}
