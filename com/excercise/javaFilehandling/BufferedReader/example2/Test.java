package com.excercise.javaFilehandling.BufferedReader.example2;

/*  
    reading character data of a file line by line using BufferedReader via another 
    BufferedReader
*/

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
            creating first BufferedReader object which will use FileReader object 
            to read file named"javaQuestiions.txt" 
        */
        BufferedReader br1 = new BufferedReader(fr);

        /* 
            creating second BufferedReader object which will use BufferedReader 
            object to read file named"javaQuestiions.txt" 
        */
        BufferedReader br2 = new BufferedReader(br1);

        // reading first line of file using 'br2'
        String line = br2.readLine(); 

        while(line!=null) {

            System.out.println(line);

            // reading next line of the file
            line = br2.readLine();
        }

        // closing second BufferedReader
        br2.close();
    }
}
