package com.excercise.javaFilehandling.FileHandlingBasics.example3;

// creating new file inside some other directory using directory path

import java.io.File;
import java.io.IOException;

public class Test {
    
    public static void main(String[] args) throws IOException {
        
        /*
            creating file object

            if specified directory path is not present then at the time of 
            file creation, it will give Exception
        */
        File f = new File("newFolder", "abc.txt");

        // checking if file named 'abc.txt' exists inside 'newFolder' or not
        System.out.println(f.exists());

        /* 
            creating new file named "abc.txt" inside directory named "newFolder" 
            if it doesn't exist
        */
        if(f.createNewFile()) {
            
            // consoling output is new file got created
            System.out.println("File named " + f.getName() + " created inside " + f.getParent());
        }
        else {

            // consoling output is new file has not created
            System.out.println("File named " + f.getName() + " already exist inside " + f.getParent());
        }

        if(f.delete()) {

            System.out.println("File deleted successfully");
        }
    }
} 

