package com.excercise.javaFilehandling.PrintWriter.example2;

// appending into a file using PrintWriter via a FileWriter 

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Test {
    
    public static void main(String[] args) throws IOException {
        
        /* 
            creating FileWriter object that will create new file if specified file 
            doesn't exist
        */
        FileWriter fw = new FileWriter("abc.txt", true);

        /* 
            creating PrintWriter object to write character data into the file 
            via Filewriter object
        */
        PrintWriter pw = new PrintWriter(fw);

        // appending using write method

        pw.write("Writing to file using write() method\n\n");

        pw.write("Name : Abhishek \nGender : ");

        pw.write('M');

        pw.write("\nId : ");

        pw.write(new char[] {'2', 100, 'C', 'D'});

        pw.write('\n');

        // appending using print and println method

        pw.println("Writing to file using print() and println() method\n");

        pw.println("Name : Abhishek");

        pw.print("Gender : ");

        pw.println('M');

        pw.print("Id : ");

        pw.print(new char[]{'d', 'g', 'l'});

        pw.println(234);

        pw.print("Passed : ");

        pw.println(true);

        // flushing all the character if some character got stuck while writing
        pw.flush();

        // closing the PrintWriter
        pw.close();
    }
}
