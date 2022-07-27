package com.excercise.javaFilehandling.FileHandlingBasics.example7;

// printing list of files and directories inside c: drive

import java.io.File;

public class Test {
    
    public static void main(String[] args) {
        
        File f = new File("c:/");

        // printing files and directories name
        for(String name : f.list()) {

            System.out.println(name);
        }
    }
}
