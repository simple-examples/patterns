package com.kovko.eager.staticblock;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * Author: eukovko
 * Date: 4/20/2020
 */
class StaticBlockSingletonTest {

    @Test
    @DisplayName("Singleton is always the same")
    void testSingleton() {

        StaticBlockSingleton StaticBlockSingletonA = StaticBlockSingleton.getInstance();
        StaticBlockSingleton StaticBlockSingletonB = StaticBlockSingleton.getInstance();

        assertThat(StaticBlockSingletonA).as("SingletonA is equal to SingletonB").isSameAs(StaticBlockSingletonB);
    }

    @Test
    @DisplayName("Exception during reflective creation")
    void testReflectionBreak() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<StaticBlockSingleton> constructor = StaticBlockSingleton.class.getDeclaredConstructor();
        assertThat(constructor).as("The class doesn't have a default constructor").isNotNull();

        constructor.setAccessible(true);
        assertThatExceptionOfType(InvocationTargetException.class)
                .isThrownBy(()-> constructor.newInstance())
                .withCauseInstanceOf(DuplicateSingletonException.class);
    }
}