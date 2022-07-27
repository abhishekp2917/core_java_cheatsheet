package com.excercise.javaFilehandling.PrintWriter.example4;

// merging character data from two files into third file using PrintWriter and BufferedReader

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Test {
    

    public static void mergeFile(File src1, File src2, File target) throws IOException {

        PrintWriter pw = new PrintWriter(target);

        BufferedReader br1 = new BufferedReader(new FileReader(src1));
        BufferedReader br2 = new BufferedReader(new FileReader(src2));

        String line1 = br1.readLine();
        String line2 = br2.readLine();

        while(line1!=null) {

            pw.println(line1);
            line1 = br1.readLine();
        }

        while(line2!=null) {
            
            pw.println(line2);
            line2 = br2.readLine();
        }

        pw.flush();
        pw.close();
        br1.close();
        br2.close();
    }

    public static void main(String[] args) throws IOException {
        
        File f1 = new File("abc.txt");
        File f2 = new File("def.txt");

        PrintWriter pw1 = new PrintWriter(f1);
        PrintWriter pw2 = new PrintWriter(f2);

        pw1.println("Abhishek");
        pw1.println("Saurabh");
        pw1.println("Ravi");
        pw1.println("Tushar");

        pw2.println("Avanish");
        pw2.println("Shakshi");
        pw2.println("Tanisha");
        pw2.println("Aman");

        pw1.flush();
        pw2.flush();

        pw1.close();
        pw2.close();

        mergeFile(f1, f2, new File("xyz.txt"));
    }
}
