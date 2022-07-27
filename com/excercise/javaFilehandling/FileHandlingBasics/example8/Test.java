package com.excercise.javaFilehandling.FileHandlingBasics.example8;

// printing list of files inside c: drive

import java.io.File;

public class Test {
    
    public static void main(String[] args) {
        
        File f = new File("c://");

        // printing files and directories name
        for(String name : f.list()) {

            File tempFile = new File("c://", name);

            if(tempFile.isFile()) System.out.println(name);
        }
    }
}
