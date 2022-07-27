package com.excercise.javaFilehandling.FileWriter.example2;

// appending character to the file using FileWriter 

import java.io.FileWriter;
import java.io.IOException;

public class Test {
    
    public static void main(String[] args) throws IOException {
        
        /* 
            creating FileWriter object that will create new file if specified file 
            doesn't exist
        */
        FileWriter fw = new FileWriter("abc.txt", true);

        // appending string to the file named "abc.txt"
        fw.write("Abhishek Pandey \nId : ");

        // appending a single character to the file named "abc.txt"
        fw.write('M');

        // appending a character array to the file named "abc.txt"
        fw.write(new char[]{'2', '3', '4', '2'});

        // flushing all the character if some character got stuck while writing
        fw.flush();

        // closing the FileWriter
        fw.close();
    }
}

