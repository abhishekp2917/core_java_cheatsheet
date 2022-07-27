package com.excercise.javaSerialization.SerializationInheritance.example1;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;

/* 
    Parent class implements Serializable interface which is to be serialized

    As Parent implements Serializable interface, all its child can be serialized without 
    implementing Serializable interface  
*/
class Parent implements Serializable {

    // Parent class instance variable
    transient String s;
    transient int i;
    double j;

    // Parent class constructor
    Parent(String s, int i, double j) {
        this.s = s;
        this.i = i;
        this.j = j;
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {

        String encryptedString = "abc" + this.s;
        int encryptedNumber = this.i + 1111;

        oos.defaultWriteObject();

        oos.writeObject(encryptedString);
        oos.writeInt(encryptedNumber);
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {

        ois.defaultReadObject();

        this.s = ((String) ois.readObject()).substring(3);
        this.i = ois.readInt()-1111;
    }
}


/* 
    child class don't need to implement Serializable interface as its parent already
    implements Serializable interface
    
    Hence, Child class is can also be serialized
*/
class Child extends Parent {

    // Child class instance variable
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

    private void writeObject(ObjectOutputStream oos) throws IOException {

        String encryptedString = "abc" + this.x;
        int encryptedNumber = this.y + 1111;

        oos.defaultWriteObject();

        oos.writeObject(encryptedString);
        oos.writeInt(encryptedNumber);
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {

        ois.defaultReadObject();

        this.x = ((String) ois.readObject()).substring(3);
        this.y = ois.readInt()-1111;
    }

}

public class Test {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        // creating Parent class object which is to be serialized 
        Parent p1 = new Parent("Parent", 100, 200.0f);

        // creating child class object which is to be serialized 
        Child c1 = new Child("Parent", 100, 200, "Child", 10, 20.0f);

        // _______________________before serialization_____________________________

        System.out.println("Before serialization");

        System.out.println(p1.s + " " + p1.i + " " + p1.j);
        System.out.println(c1.s + " " + c1.i + " " + c1.j + " " + c1.x + " " + c1.y + " " + c1.z);

        FileOutputStream fos = new FileOutputStream("abc.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        // serializing Parent class object into file named "abc.txt"
        oos.writeObject(p1);

        // serializing Child class object into file named "abc.txt"
        oos.writeObject(c1);

        oos.close();

        FileInputStream fis = new FileInputStream("abc.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        // de-serializing Parent class object from file named "abc.txt"
        Parent p2 = (Parent) ois.readObject();

        // de-serializing Child class object from file named "abc.txt"
        Child c2 = (Child) ois.readObject();

        // _________________________after de-serialization_____________________________

        System.out.println("After de-serialization");

        System.out.println(p2.s + " " + p2.i + " " + p2.j);
        System.out.println(c2.s + " " + c2.i + " " + c2.j + " " + c2.x + " " + c2.y + " " + c2.z);

        ois.close();
    } 
}

