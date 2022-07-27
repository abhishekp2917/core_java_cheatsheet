package com.excercise.javaSerialization.SerializationInheritance.example3;

/*  serializing inherited variables while serializing child class object
    using customized serialization 

    here parent class dosen't implements serializable interface but child class does
*/

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;

/* 
    Parent class can't be serialized as it doesn't implement Serializable 
    interface

    As Parent dosn't implement Serializable interface, while serializing Child 
    class object parent class JVM will run parent class instance control flow 
    and no-argument constructor at the time of de-serialization 
*/
class Parent {

    // Parent class instance variable
    String a;
    int b;

    {
        System.out.println("Parent instance block");
    }

    // Parent class argument constructor
    Parent(String a, int b) {
        this.a = a;
        this.b = b;
        System.out.println("Parent class argument constructor");
    }

    /* 
        Parent class no-argument constructor

        It is mandatory to define no-argument constructor in parent class if we
        want to serialize child class object else we will get InvalidClassException
    */
    Parent() {
        System.out.println("Parent class no-argument constructor");
    }
}


/* 
    Child class implements Serializable interface but its parent class doesn't due
    to which variables inherited from parent will be serialized with default value

    but we can serialize inherited variables using customized serialization
*/
class Child extends Parent  implements Serializable {

    // Child class instance variable
    // transient variable will be assigned default value at the time serialization
    transient String x;
    transient int y;

    {
        System.out.println("Child instance block");
    }

    // Child class constructor
    Child(String a, int b, String x, int y) {
        super(a, b);
        this.x = x;
        this.y = y;
        System.out.println("Child argument constructor");
    }

    // this method will be called by JVM at the time of serialization
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();

        oos.writeObject(this.x);
        oos.writeInt(this.y);

        // serializing parent class variable inherited by child class
        oos.writeObject(this.a);
    }

    // this metthod will be called by JVM at the time of de-serialization
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();

        this.x = ((String) ois.readObject());
        this.y = ois.readInt();

        // de-serializing parent class variable inherited by child class
        this.a = ((String) ois.readObject());
    }

}

public class Test {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // creating child class object which is to be serialized 
        Child c1 = new Child("Parent", 100, "Child", 10);

        System.out.println(c1.a + " " + c1.b + " " + c1.x + " " + c1.y);

        // _______________________________serialization_____________________________

        System.out.println("Serialization started...");

        FileOutputStream fos = new FileOutputStream("abc.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        // serializing Child class object into file named "abc.txt"
        oos.writeObject(c1);

        oos.close();

        // ________________________________de-serialization_____________________________

        System.out.println("De-serialization started...");

        FileInputStream fis = new FileInputStream("abc.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        // de-serializing Child class object from file named "abc.txt"
        Child c2 = (Child) ois.readObject();

        /* 
            even though parent class is not Serializable, but inherited variables
            from parent class will be serialized using default serialization
        */
        System.out.println(c2.a + " " + c2.b + " " + c2.x + " " + c2.y);

        ois.close();
    } 
}


