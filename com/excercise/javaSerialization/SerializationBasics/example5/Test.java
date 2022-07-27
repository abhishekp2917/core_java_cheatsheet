package com.excercise.javaSerialization.SerializationBasics.example5;

// serializing and de-serializing multiple objects into same file

import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

// declaring Dog class
class Dog implements Serializable {

    @Override
    public String toString() {
        return "Dog object";
    }
}

// declaring Cat class
class Cat implements Serializable {

    @Override
    public String toString() {
        return "Cat object";
    }
} 

// declaring Mouse class
class Mouse implements Serializable {

    @Override
    public String toString() {
        return "Mouse object";
    }
}

public class Test {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // creating Dog object
        Dog d1 = new Dog();

        // creating Cat object
        Cat c1 = new Cat();

        // creating Mouse object
        Mouse m1 = new Mouse();

        // ___________________________serialization_______________________________
        
        // creating FileOutputStream object to make connection with file named "abc.txt"
        FileOutputStream fos = new FileOutputStream("abc.txt");

        // creating ObjectOutputStream object to write object to file via FileOutputStream
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        // serializing Mouse object to file named "abc.txt"
        oos.writeObject(m1);

        // serializing cat object to file named "abc.txt"
        oos.writeObject(c1);

        // serializing Dog object to file named "abc.txt"
        oos.writeObject(d1);

        // closing ObjectOuputstream
        oos.close();


        // ___________________________de-serialization______________________________

        // creating FileInputStream object to make connection with file named "abc.txt"
        FileInputStream fis = new FileInputStream("abc.txt");

        // creating ObjectInputStream object to read object from the file via FileInputStream
        ObjectInputStream ois = new ObjectInputStream(fis);

        // de-serializing objects from file "abc.txt" in same order we serialized them
        Mouse m2 = (Mouse) ois.readObject();

        Cat c2 = (Cat) ois.readObject();

        Dog d2 = (Dog) ois.readObject();

        // printing mouse object
        System.out.println(m2);

        // printing cat object
        System.out.println(c2);

        // printing dog object
        System.out.println(d2);

        // closing ObjectInputStream
        ois.close();
    }
}



