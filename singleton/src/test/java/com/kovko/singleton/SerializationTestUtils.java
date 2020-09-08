package com.kovko.singleton;

import java.io.*;

/**
 * Author: eukovko
 * Date: 4/28/2020
 */
public class SerializationTestUtils {

    private SerializationTestUtils() {
        throw new IllegalStateException("Cannot create an instance of a utility class");
    }

    public static void serialize(File file, Object object) throws IOException {
        try(FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(object);
            oos.flush();
        }
    }

    public static <T> T deserialize(File file) throws IOException, ClassNotFoundException {
        try(FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (T) ois.readObject();
        }
    }
}
