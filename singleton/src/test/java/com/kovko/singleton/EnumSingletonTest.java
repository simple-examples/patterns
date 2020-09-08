package com.kovko.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.lang.reflect.Constructor;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * Author: eukovko
 * Date: 4/18/2020
 */
@DisplayName("Enum singleton tests")
class EnumSingletonTest {

    @TempDir
    Path path = Paths.get("testFolder");

    @Test
    @DisplayName("Singleton serialization breaking test")
    void singletonSerializationTest() throws IOException, ClassNotFoundException {
        File file = path.resolve("singleton.ser").toFile();
        EnumSingleton instance = EnumSingleton.INSTANCE;
        SerializationTestUtils.serialize(file, instance);
        EnumSingleton instanceSerializationDuplicate = SerializationTestUtils.deserialize(file);
        assertThat(instance).as("Duplication of the singleton via serialization").isSameAs(instanceSerializationDuplicate);
    }

    @Test
    @DisplayName("Singleton reflection breaking test")
    void singletonReflectionTest() throws NoSuchMethodException {
        Constructor<EnumSingleton> constructor = EnumSingleton.class.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .as("Reflective creation of an Enum type")
                .isThrownBy(constructor::newInstance);
    }

}