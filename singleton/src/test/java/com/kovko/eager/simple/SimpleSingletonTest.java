package com.kovko.eager.simple;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author: eukovko
 * Date: 4/18/2020
 */
@DisplayName("Test simple singleton implementation")
class SimpleSingletonTest {

    @Test
    @DisplayName("Singletons are always the same")
    void singletonTest() {

        SimpleSingleton simpleSingletonA = SimpleSingleton.getInstance();
        SimpleSingleton simpleSingletonB = SimpleSingleton.getInstance();

        assertThat(simpleSingletonA).as("SingletonA is equal to SingletonB").isSameAs(simpleSingletonB);
    }

    @Test
    @DisplayName("Create another singleton instance with reflection")
    void reflectionBreak() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {

        SimpleSingleton instance = SimpleSingleton.getInstance();

        Constructor<SimpleSingleton> constructor = SimpleSingleton.class.getDeclaredConstructor();
        assertThat(constructor).as("The class doesn't have a default constructor").isNotNull();

        constructor.setAccessible(true);
        SimpleSingleton reflectedInstance = constructor.newInstance();

        assertThat(instance).as("Reflected and normal instances are not the same").isNotSameAs(reflectedInstance);
    }


}