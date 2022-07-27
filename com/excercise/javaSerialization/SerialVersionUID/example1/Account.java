package com.excercise.javaSerialization.SerialVersionUID.example1;

import java.io.Serializable;

/* 
    Account class which will be serialized by Sender class and will be de-serialized 
    by Receiver 
    
    In this class as serialVersionUID variable is not defined, due to which at the 
    time of serialization JVM will generate default serialVersionUID and will 
    associate that serialVersionUID with the serializing object

    Since, this class doesn't have user defined serialVersionUID, will 
    de-serializing we may get InvalidClassException due to serialVersionUID mismatch
*/
public class Account implements Serializable {
    
    String name;
    double balance;

    Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }
}
