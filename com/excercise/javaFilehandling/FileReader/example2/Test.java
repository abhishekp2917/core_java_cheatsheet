package com.excercise.javaFilehandling.FileReader.example2;

// copying characters of a file using FileReader

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test {
    
    public static void main(String[] args) throws IOException {

        // creating file object which will represent the file that is to be read
        File f = new File("javaQuestions.txt");
        
        // creating FileReader object that will read a file 'f' 
        FileReader fr = new FileReader(f);

        // char array to store characters of file that is to be read
        char[] ch = new char[(int) f.length()];

        // reading all the characters of the file 'f' and storing it in char array 'ch'
        fr.read(ch);

        // iterating over char array 'ch' and printing each character
        for(char c : ch) {

            // printing character
            System.out.print(c);
        }

        // closing FileReader
        fr.close();
    }
}
