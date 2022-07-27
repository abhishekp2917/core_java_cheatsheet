package com.excercise.javaSerialization.SerialVersionUID.example1;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/* 
    Sender class which will serialize Account class object which will be 
    de-serialized by the receiver class 
*/
public class Sender {
    
    public static void main(String[] args) throws Exception {
        
        // creating Account class object
        Account a = new Account("Abhishek", 20000);

        System.out.println(a.name + " " + a.balance);

        FileOutputStream fos = new FileOutputStream("abc.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        // serializing Account object into file named "abc.txt"
        oos.writeObject(a);

        oos.close();
    }
}