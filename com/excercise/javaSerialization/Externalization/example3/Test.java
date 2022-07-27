package com.excercise.javaSerialization.Externalization.example3;

/* 
    inheriatnce in Externalization where Parent class doesn't implements 
    Externalizable interface but Child class does
*/

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;


/* 
    Parent class doesn't implements Externalizable due to which it can't be 
    serialized

    but it must have no-argument constructor because at tthe time of de-serializing
    child class object, JVM will create child class object by calling child and 
    parent class no-argument constructor
*/
class Parent {

    /* 
        even though these two variables are transient we can serialize them using
        Externalization
    */
    transient int a;
    transient String b;

    String c;

    /* 
        instance block will be called at the time of de-serialization as new object 
        will be created by JVm
    */
    {
        System.out.println("Parent class instance block");
    }

    Parent(int a, String b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
        System.out.println("Parent class argument constructor");
    }

    /* 
        If no-argument constructor is not there, then we will get 
        InvalidClassException
    */
    Parent() {
        System.out.println("Parent class no-argument constructor");
    }
}

/* 
    Child class implements Externalizable interface and hence we can serialize it
    but can't serialize its parent class
*/
class Child extends Parent implements Externalizable {
    
    /* 
        even though these two variables are transient we can serialize them using
        Externalization
    */
    transient int x;
    transient String y;

    String z;

    /* 
        instance block will be called at the time of de-serialization as new object 
        will be created by JVm
    */
    {
        System.out.println("Child class instance block");
    }

    Child(int a, String b, String c, int x, String y, String z) {
        super(a, b, c);
        this.x = x;
        this.y = y;
        this.z = z;
        System.out.println("Child class argument constructor");
    }

    /* 
        class implementing Externalizable must have public no-argument constructor 
        as while de-serializing JVM will create this class object and will call 
        no-argument constructor

        If no-argument constructor is not there, then we will get 
        InvalidClassException
    */
    public Child() {
        System.out.println("Child class no-argument constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

        /* 
            serializing only certain required instance variables

            these variables are transient still we can serialize them using 
            Externalization these shows that transient keyword has no importance in
            Externalization
        */
        out.writeInt(this.x);
        out.writeObject(this.y);
        out.writeInt(this.a);
        out.writeObject(this.b);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

        // de-serializing serialized variables and assigning it to respective variables
        this.x = in.readInt();
        this.y = (String) in.readObject();
        this.a = in.readInt();
        this.b = (String) in.readObject();
    }
}


public class Test {
    
    public static void main(String[] args) throws Exception {

        // creating Child class object
        Child c1 = new Child(10, "Parent2", "Hello2", 1, "Child1", "World1");

        System.out.println(c1.a + " " + c1.b + " " + c1.c + " " + c1.x + " " + c1.y + " " + c1.z);

        FileOutputStream fos = new FileOutputStream("abc.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        System.out.println("Serialization started...");

        // serializing Child class object variables
        oos.writeObject(c1);

        System.out.println("Serialization completed...");

        oos.close();

        FileInputStream fis = new FileInputStream("abc.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        System.out.println("De-serialization started...");

        // de-serializing Child class object variables
        Child c2 = (Child) ois.readObject();

        System.out.println("De-serialization completed...");

        /* 
            variables that was serialized at the time of serialization, only
            those variable will have its original value while other variable will 
            have default value
        */
        System.out.println(c2.a + " " + c2.b + " " + c2.c + " " + c2.x + " " + c2.y + " " + c2.z);

        ois.close();
    }
}


