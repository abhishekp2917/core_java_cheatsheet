package com.excercise.javaFilehandling.FileHandlingBasics.example2;

// creating new directory if it doesn't exist

import java.io.File;
import java.io.IOException;

public class Test {
    
    public static void main(String[] args) throws IOException {
        
        // creating file object
        File f = new File("newFolder");

        // checking if directory exists or not
        System.out.println(f.exists());

        // creating new directory if it doesn't exist
        if(f.mkdir()) {
            
            // consoling output is new directory got created
            System.out.println("Directory named " + f.getName() + " created in CWD");
        }
        else {

            // consoling output is new directory has not created
            System.out.println("Directory named " + f.getName() + " already exists in CWD");
        }

        if(f.delete()) {

            System.out.println("Directory deleted successfully");
        }
    }
} 
