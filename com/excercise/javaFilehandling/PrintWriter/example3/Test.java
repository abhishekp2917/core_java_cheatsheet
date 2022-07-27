package com.excercise.javaFilehandling.PrintWriter.example3;

// writing into a file using PrintWriter directly without using any Writer object

import java.io.IOException;
import java.io.PrintWriter;

public class Test {
    
    public static void main(String[] args) throws IOException {
        
        /* 
            creating PrintWriter object to write character data directly into the 
            file named "abc.txt" 
            
        */
        PrintWriter pw = new PrintWriter("abc.txt");

        // writing using write method

        pw.write("Writing to file using write() method\n\n");

        pw.write("Name : Abhishek \nGender : ");

        pw.write('M');

        pw.write("\nId : ");

        pw.write(new char[] {'2', 100, 'C', 'D'});

        pw.write('\n');

        // writing using print and println method

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
