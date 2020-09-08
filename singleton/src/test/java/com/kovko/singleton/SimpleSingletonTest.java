package com.kovko.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.kovko.singleton.SerializationTestUtils.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * Author: eukovko
 * Date: 4/28/2020
 */
@DisplayName("Non serializable simple singleton tests")
class SimpleSingletonTest {

    @TempDir
    Path path = Paths.get("testFolder");

    @Test
    @DisplayName("Test simple singleton implementation")
    void testHappyPath(){
        SimpleSingleton instanceA = SimpleSingleton.getInstance();
        SimpleSingleton instanceB = SimpleSingleton.getInstance();
        assertThat(instanceA).as("Singleton instances are not the same").isSameAs(instanceB);
    }

    @Test
    @DisplayName("Singleton reflection breaking test")
    void testReflectionBreak() throws NoSuchMethodException {
        Constructor<SimpleSingleton> constructor = SimpleSingleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        assertThatExceptionOfType(InvocationTargetException.class)
                .as("Singleton constructor is accessible via reflection")
                .isThrownBy(constructor::newInstance)
                .withCause(new IllegalStateException("Cannot create another instance of the singleton"));
    }

    @Test
    @DisplayName("Singleton serialization breaking test")
    void testSerializationBreak() throws IOException, ClassNotFoundException {
        File file = path.resolve("singleton.ser").toFile();
        SimpleSingleton instance = SimpleSingleton.getInstance();
        serialize(file, instance);
        SimpleSingleton deserializedSingleton = deserialize(file);
        assertThat(instance)
                .as("Singleton instances are not the same")
                .isSameAs(deserializedSingleton);
    }
}