package com.excercise.javaSerialization.SerializationInheritance.example2;

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
    String s;
    int i;
    double j;

    {
        System.out.println("Parent instance block");
    }

    // Parent class argument constructor
    Parent(String s, int i, double j) {
        System.out.println("Parent class argument constructor");
        this.s = s;
        this.i = i;
        this.j = j;
    }

    /* 
        Parent class no-argument constructor

        It is mandatory to define no-argument constructor in parent class if we
        want to serialize child class object
    */
    Parent() {
        System.out.println("Parent class no-argument constructor");
    }
}


/* 
    Child class implements Serializable interface but its parent class doesn't due
    to which variables inherited from parent will be serialized with default value
*/
class Child extends Parent  implements Serializable {

    // Child class instance variable
    // transient variable will be assigned default value at the time serialization
    transient String x;
    transient int y;
    double z;

    // Child class constructor
    Child(String s, int i, float j, String x, int y, double z) {
        super(s, i, j);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // this metthod will be called by JVM at the time of serialization
    private void writeObject(ObjectOutputStream oos) throws IOException {

        String encryptedString = "abc" + this.x;
        int encryptedNumber = this.y + 1111;

        oos.defaultWriteObject();

        oos.writeObject(encryptedString);
        oos.writeInt(encryptedNumber);
    }

    // this metthod will be called by JVM at the time of de-serialization
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {

        ois.defaultReadObject();

        this.x = ((String) ois.readObject()).substring(3);
        this.y = ois.readInt()-1111;
    }

}

public class Test {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // creating child class object which is to be serialized 
        Child c1 = new Child("Parent", 100, 200, "Child", 10, 20.0f);

        // _______________________before serialization_____________________________

        System.out.println("Before serialization");

        System.out.println(c1.s + " " + c1.i + " " + c1.j + " " + c1.x + " " + c1.y + " " + c1.z);

        FileOutputStream fos = new FileOutputStream("abc.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        // serializing Child class object into file named "abc.txt"
        oos.writeObject(c1);

        oos.close();

        FileInputStream fis = new FileInputStream("abc.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        // de-serializing Child class object from file named "abc.txt"
        Child c2 = (Child) ois.readObject();

        // _________________________after de-serialization_____________________________

        System.out.println("After de-serialization");

        System.out.println(c2.s + " " + c2.i + " " + c2.j + " " + c2.x + " " + c2.y + " " + c2.z);

        ois.close();
    } 
}


