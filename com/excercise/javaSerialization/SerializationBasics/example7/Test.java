package com.excercise.javaSerialization.SerializationBasics.example7;


/* 
    accessing object method after de-serialization of that obejct
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


/*
    Person class which is to be serialized and then de-serialized has to implement
    Serializable interface else we will get NotSerialzableException
*/
class Person implements Serializable {

    String name;

    Person(String name) {
        this.name = name;
    }

    public void method1() {

        System.out.println("Person class instance method");
    }

    public static void method2() {

        System.out.println("Person class static method");
    }
}

public class Test {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // creating Person class object which is to be serialized and de-serialized
        Person p1 = new Person("Abhishek");

        System.out.println("Before serialization - Name : " + p1.name);

        // ___________________________serialization_______________________________
        
        // creating FileOutputStream object to make connection with file named "abc.txt"
        FileOutputStream fos = new FileOutputStream("abc.txt");

        // creating ObjectOutputStream object to write object to file via FileOutputStream
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        // writing Person object to file named "abc.txt"
        oos.writeObject(p1);

        // closing ObjectOuputstream
        oos.close();


        // ___________________________de-serialization______________________________

        // creating FileInputStream object to make connection with file named "abc.txt"
        FileInputStream fis = new FileInputStream("abc.txt");

        // creating ObjectInputStream object to read object from the file via FileInputStream
        ObjectInputStream ois = new ObjectInputStream(fis);

        /*
            reading Person object from the file named "abc.txt" and type casting it
            to Person type from Object type 
        */
        Person p2 = (Person) ois.readObject();

        System.out.println("After de-serialization - Name : " + p2.name);

        p2.method1();

        Person.method2();

        // closing ObjectInputStream
        ois.close();
    }
}
