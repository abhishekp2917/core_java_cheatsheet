package com.excercise.javaSerialization.Externalization.example1;

// serializing only few variables of the account object using Externalization

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/* 
    Account class whose instance variable 'accountID' and 'branchName' are to be 
    serialized and to be stored into a file

    to achieve this, this class has to implement Externalizable interface
*/
class Account implements Externalizable {

    // only these two instance variable is to be stored
    int accountID;
    String branchName;

    String name;
    double balance;

    /* 
        instance block will be called at the time of de-serialization as new object 
        will be created by JVm
    */
    {
        System.out.println("Account class instance block");
    }

    Account(int accountID, String branchName, String name, double balance) {
        System.out.println("Account class argument constructor");
        this.accountID = accountID;
        this.branchName = branchName;
        this.name = name;
        this.balance = balance;
    }

    /* 
        class implementing Externalizable must have public no-argument constructor 
        as while de-serializing JVM will create this class object and will call 
        no-argument constructor

        If no-argument constructor is not there, then we will get 
        InvalidClassException
    */
    public Account() {
        System.out.println("Account class no-argument constructor");
    }

    /* 
        overriding writeExternal method in which we will define the logic for 
        serializing only required data and not the entire object

        this method will be called be the JVM at the time of serializing this class
        object
    */
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

        // serializing only certain required instance variables
        out.writeInt(this.accountID);
        out.writeObject(this.branchName);
    }

    /* 
        overriding readExternal method in which we will define the logic for 
        de-serializing data 

        this method will be called be the JVM at the time of de-serializing this 
        class object

        while de-serializing, JVM will create the object of this class and will 
        call this class no-argument constructor and will assign the data that 
        we de-serialized to the variable which we will defne in this method
    */
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

        // de-serializing serialized variables and assigning it to respective variables
        this.accountID = in.readInt();
        this.branchName = (String) in.readObject();
    }
}
public class Test {
    
    public static void main(String[] args) throws Exception {
        
        // creating Account class object
        Account a1 = new Account(1234, "Hyderabad", "Abhishek", 20000.50);

        System.out.println(a1.accountID + " " + a1.branchName + " " + a1.name + " " + a1.balance);

        FileOutputStream fos = new FileOutputStream("abc.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        System.out.println("Serialization started...");

        // serializing Account class object variables
         oos.writeObject(a1);

        System.out.println("Serialization completed...");

        oos.close();

        FileInputStream fis = new FileInputStream("abc.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        System.out.println("De-serialization started...");

        // de-serializing Account class object variables
        Account a2 = (Account) ois.readObject();

        System.out.println("De-serialization completed...");

        /* 
            variables that was serialized at the time of serialization, only
            those variable will have its original value while other variable will 
            have default value
        */
        System.out.println(a2.accountID + " " + a2.branchName + " " + a2.name + " " + a2.balance);

        ois.close();
    }
}
