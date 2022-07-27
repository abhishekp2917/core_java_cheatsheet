package com.excercise.javaFilehandling.BufferedWriter.example2;

// appending character to the file using BufferedWriter 

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Test {
    
    public static void main(String[] args) throws IOException {
        
        /* 
            creating FileWriter object that will create new file if specified file 
            doesn't exist
        */
        FileWriter fw = new FileWriter("abc.txt", true);

        /* 
            creating BufferedWriter object to write character data into the file 
            using Filewriter object
        */
        BufferedWriter bw = new BufferedWriter(fw);

        // appending string to the file named "abc.txt"
        bw.write("Abhishek Pandey");

        // adding new line into the file
        bw.newLine();

        // appending string to the file named "abc.txt"
        bw.write("Gender : Male");

        // adding new line into the file
        bw.newLine();

        // appending string to the file named "abc.txt"
        bw.write("Id : ");
        
        // appending a single character to the file named "abc.txt"
        bw.write('M');

        // appending a character array to the file named "abc.txt"
        bw.write(new char[]{'2', '3', '4', '2'});

        // adding new line into the file
        bw.newLine();

        // flushing all the character if some character got stuck while writing
        bw.flush();

        // closing the BufferedWriter
        bw.close();
    }
}

