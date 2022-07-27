package com.excercise.javaFilehandling.BufferedReader.example1;

// reading character data of a file line by line using BufferedReader

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test {
    
    public static void main(String[] args) throws IOException {
        
        /*  creating FileReader object that will read a specified file named 
            "javaQuestiions.txt"  
        */
        FileReader fr = new FileReader("javaQuestions.txt");

        /* 
            creating BufferedReader object which will use Reader object to read file
            named"javaQuestiions.txt" 
        */
        BufferedReader br = new BufferedReader(fr);

        // reading first line of file
        String line = br.readLine(); 

        while(line!=null) {

            System.out.println(line);

            // reading next line of the file
            line = br.readLine();
        }

        // closing BufferedReader
        br.close();
    }
}
