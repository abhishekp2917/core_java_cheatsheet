package com.excercise.javaSerialization.CustomizedSerialization.example1;

/* 
    customized serialization of the Account object so that we can recover lost 
    data at the time of de-serialization  
*/

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

    Account(String name, String password) {
        this.name = name;
        this.password = password;
    }

    /*
        writeObject method which will be called by JVM at the time of serialization
        this object so that we can store encrypted password in the file which will 
        be retrived at the time of de-serialization
    */
    private void writeObject(ObjectOutputStream oos) throws Exception {

        // performing default serialization
        oos.defaultWriteObject();

        // encrypting password
        String encryptedPassword = "123" + this.password;
        
        // serializing encrypted password
        oos.writeObject(encryptedPassword);
    }

    /* 
        readObject method which will be called by JVM at the time of 
        de-serialization so that we can get encrypted password.

        This encypted password will be decrypted at and will be assigned to the
        password variable
    */
    private void readObject(ObjectInputStream ois) throws Exception {

        // performing default de-serialization
        ois.defaultReadObject();

        // de-serializing encrypted password
        String encryptedPassword = (String) ois.readObject();

        // decrypting encrypted password
        this.password = encryptedPassword.substring(3);
    }
}

public class Test {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // creating Person class object which is to be serialized and de-serialized
        Account a1 = new Account("Abhishek", "abcd123");

        System.out.println("Before serialization Account Number : Name : " + a1.name + " Password : " + a1.password);

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
            due to customized serialization, we will get the original password 
            by decrypting the encrypted password
        */
        System.out.println("After serialization Account Number : Name : " + a2.name + " Password : " + a2.password);

        // closing ObjectInputStream
        ois.close();
    }
}