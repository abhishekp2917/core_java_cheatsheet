package com.excercise.javaFilehandling.FileHandlingBasics.example6;

// creating new directory inside some other directory using file object that represent that directory

import java.io.File;
import java.io.IOException;

public class Test {
    
    public static void main(String[] args) throws IOException {

        // creating file object representing directory named "parentDir"
        File parentDir = new File("parentDir");

        // creating directory named "parentDir" in CWD if it doesn't exist
        parentDir.mkdir();
        /*
            creating file object

            if specified file object representing directory is not present then at 
            the time of directory creation, it will give Exception
        */
        File childDir = new File(parentDir, "childDir");

        // checking if directory named 'childDir' exist inside 'parentDir' or not
        System.out.println(childDir.exists());

        /* 
            creating new directory named 'childDir' inside directory named 
            "parentDir" if it doesn't exist
        */
        if(childDir.mkdir()) {
            
            // consoling output is new directory got created
            System.out.println("Directory named " + childDir.getName() + " created inside " + childDir.getParent());
        }
        else {

            // consoling output is new directory has not created
            System.out.println("Directory named " + childDir.getName() + " already exist inside " + childDir.getParent());
        }

        if(childDir.delete()) {

            System.out.println("Directory deleted successfully");
        }
    }
} 

