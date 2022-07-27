package com.excercise.javaSerialization.SerializationBasics.example6;


// serializing and de-serializing object graph into a file

import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

// declaring Dog class which has cat object
class Dog implements Serializable {

    Cat c = new Cat();

    @Override
    public String toString() {
        return "Dog object";
    }
}

// declaring Cat class which has Mouse object
class Cat implements Serializable {

    Mouse m = new Mouse();

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

        // ___________________________serialization_______________________________
        
        // creating FileOutputStream object to make connection with file named "abc.txt"
        FileOutputStream fos = new FileOutputStream("abc.txt");

        // creating ObjectOutputStream object to write object to file via FileOutputStream
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        /*  
            serializing Dog object which has Cat object and Cat object has Mouse 
            object forming an Object Graph
        */
        oos.writeObject(d1);

        // closing ObjectOuputstream
        oos.close();


        // ___________________________de-serialization______________________________

        // creating FileInputStream object to make connection with file named "abc.txt"
        FileInputStream fis = new FileInputStream("abc.txt");

        // creating ObjectInputStream object to read object from the file via FileInputStream
        ObjectInputStream ois = new ObjectInputStream(fis);

        // de-serializing Dog object from file named "abc.txt"
        Dog d2 = (Dog) ois.readObject();

        // printing dog object
        System.out.println(d2);

        // closing ObjectInputStream
        ois.close();
    }
}



