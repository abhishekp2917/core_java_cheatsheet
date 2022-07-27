package com.excercise.javaSerialization.SerializationBasics.example4;

// declaring final variable as transient

import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* 
    Account object which is to be serialized and de-serialized 
*/
class Account implements Serializable {

    String name;
    
    /*  making password as transient so that its default value will be stored in 
        file at the time of serialization
    */
    transient String password;

    /*  
        making final variable accountNumber as transient 

        final variable will participate in the serialization directly by the value. 
        Hence, declaring a final variable as transient has no impact as JVM won't be 
        able to know whether that constant value is transient or not
    */
    transient final int accountNumber = 123456789;

    Account(String name, String password) {
        this.name = name;
        this.password = password;
    }
}

public class Test {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // creating Person class object which is to be serialized and de-serialized
        Account a1 = new Account("Abhishek", "abcd123");

        System.out.println("Before serialization Account Number : " + a1.accountNumber + " Name : " + a1.name + " Password : " + a1.password);

        // ___________________________serialization_______________________________
        
        // creating FileOutputStream object to make connection with file named "abc.txt"
        FileOutputStream fos = new FileOutputStream("abc.txt");

        // creating ObjectOutputStream object to write object to file via FileOutputStream
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        // writing account object to file named "abc.txt"
        oos.writeObject(a1);

        // closing ObjectOuputstream
        oos.close();


        // ___________________________de-serialization______________________________

        // creating FileInputStream object to make connection with file named "abc.txt"
        FileInputStream fis = new FileInputStream("abc.txt");

        // creating ObjectInputStream object to read object from the file via FileInputStream
        ObjectInputStream ois = new ObjectInputStream(fis);

        /*
            reading Account object from the file named "abc.txt" and type casting it
            to Account type from Object type 
        */
        Account a2 = (Account) ois.readObject();

        /* 
            as final variable accountNumber is participate in serialization directly
            by value, serialization will have no impact on it and after
            de-serialization we will get its original value
        */
        System.out.println("Before serialization Account Number : " + a2.accountNumber + " Name : " + a2.name + " Password : " + a2.password);

        // closing ObjectInputStream
        ois.close();
    }
}


