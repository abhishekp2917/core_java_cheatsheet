package com.excercise.javaFilehandling.FileReader.example1;

// reading characters of a file using FileReader

import java.io.FileReader;
import java.io.IOException;

public class Test {
    
    public static void main(String[] args) throws IOException {
        
        // creating FileReader object that will read a specified file named "javaQuestiions.txt"  
        FileReader fr = new FileReader("javaQuestions.txt");

        // reading character of specified file
        int ch = fr.read();

        while(ch!=-1) {

            // printing character
            System.out.print((char) ch);

            // reading next character
            ch = fr.read();
        }

        // closing FileReader
        fr.close();
    }
}
