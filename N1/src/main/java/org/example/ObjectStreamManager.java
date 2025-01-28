package org.example;

import java.io.*;

public class ObjectStreamManager {
    public static class SerializableObject implements Serializable {
        String id;
        String word;
        int num;

        public SerializableObject(String id, String word, int num) {
            this.id = id;
            this.word = word;
            this.num = num;
        }

        @Override
        public String toString() {
            return "SerializableObject {id=" + this.id + ", word=" + this.word + ", num=" + this.num + "}";
        }
    }

    static public void serializeObject(String[] fieldsValues) {
        if (fieldsValues.length != 3) {
            throw new RuntimeException("Wrong numbers of field values");
        }
        SerializableObject newSerializable = new SerializableObject(fieldsValues[0], fieldsValues[1], Integer.parseInt(fieldsValues[2]));
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("../../assets/serialized.ser"));) {
            out.writeObject(newSerializable);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static public void retrieveSerializedObject(String path) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
            SerializableObject retrievedSerializable = (SerializableObject) in.readObject();
            System.out.println(retrievedSerializable.toString());
        } catch (IOException e) {
            throw new RuntimeException("File not found", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
