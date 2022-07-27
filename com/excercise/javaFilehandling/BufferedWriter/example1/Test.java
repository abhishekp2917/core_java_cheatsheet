package com.excercise.javaFilehandling.BufferedWriter.example1;

import java.io.BufferedWriter;

// overriding character of the file using BufferedWriter 

import java.io.FileWriter;
import java.io.IOException;

public class Test {
    
    public static void main(String[] args) throws IOException {
        
        /* 
            creating FileWriter object that will create new file if specified file 
            doesn't exist
        */
        FileWriter fw = new FileWriter("abc.txt");

        /* 
            creating BufferedWriter object to write character data into the file 
            using Filewriter object
        */
        BufferedWriter bw = new BufferedWriter(fw);

        // overriding string to the file named "abc.txt"
        bw.write("Abhishek Pandey");

        // adding new line into the file
        bw.newLine();

        // overriding string to the file named "abc.txt"
        bw.write("Gender : Male");

        // adding new line into the file
        bw.newLine();

        // overriding string to the file named "abc.txt"
        bw.write("Id : ");
        
        // overriding a single character to the file named "abc.txt"
        bw.write('M');

        // overriding a character array to the file named "abc.txt"
        bw.write(new char[]{'2', '3', '4', '2'});

        // adding new line into the file
        bw.newLine();

        // flushing all the character if some character got stuck while writing
        bw.flush();

        // closing the BufferedWriter
        bw.close();
    }
}
