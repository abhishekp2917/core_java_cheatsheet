package com.excercise.javaFilehandling.FileHandlingBasics.example1;

// creating new file if it doesn't exist

import java.io.File;
import java.io.IOException;

public class Test {
    
    public static void main(String[] args) throws IOException {
        
        // creating file object
        File f = new File("Text.txt");

        // checking if file exists or not
        System.out.println(f.exists());

        // creating new file if it doesn't exist
        if(f.createNewFile()) {
            
            // consoling output is new file got created
            System.out.println("File named " + f.getName() + " created in CWD");
        }
        else {

            // consoling output is new file has not created
            System.out.println("File named " + f.getName() + " already exists in CWD");
        }

        if(f.delete()) {

            System.out.println("File deleted successfully");
        }
    }
} 