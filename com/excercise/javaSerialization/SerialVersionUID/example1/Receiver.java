package com.excercise.javaSerialization.SerialVersionUID.example1;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/* 
    Receiver class will de-serialize the Account object from "abc.txt" file 
*/
public class Receiver {
    
    public static void main(String[] args) throws Exception {

        FileInputStream fis = new FileInputStream("abc.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        // de-serializing Account class object 
        Account a = (Account) ois.readObject();

        System.out.println(a.name + " " + a.balance);

        ois.close();
    }
}
