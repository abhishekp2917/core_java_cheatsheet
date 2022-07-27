package com.excercise.javaSerialization.SerialVersionUID.example2;

import java.io.Serializable;

/* 
    Account class which will be serialized by Sender class and will be de-serialized 
    by Receiver 
    
    In this class as serialVersionUID variable is defined, JVM won't generate 
    serialVersionUID and will use given serialVersionUID at the time of
    seraialization of this class object
*/
public class Account implements Serializable {
    
    /* 
        defining own serialVersionUID which must be public static and final of 
        long data type  
    */
    public static final long serialVersionUID = 10;
    String name;
    double balance;

    Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }
}
