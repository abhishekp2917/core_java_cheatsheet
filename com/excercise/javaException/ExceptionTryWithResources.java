package com.excercise.javaException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ExceptionTryWithResources {

    public static void main(String[] args) throws Exception{

        System.out.println("\n____________Before try with resources concept_____________\n");

        // before try with resources concept, one has to explicitly close the resources
        // opened inside try block as it is highly recommended to close opened resources

        BufferedReader br1 = null;
        FileReader fr1 = null;

        try{
            // creating FileReader object which throws FileNotFoundException
            // that has to be handled
            fr1 = new FileReader("new.txt");

            // creating buffer reader object which has to be closed eventually
            // this throws IOException that has to be handled
            br1 = new BufferedReader(fr1);
        }
        catch(IOException e){
            // handling IOException
            e.printStackTrace();
        }
        finally{
            try{
                // closing BufferReader object
                br1.close();
            }
            catch(NullPointerException e){
                // handling NullPointerException
                e.printStackTrace();
            }
        }




        // ____________________________________________________________________________________
        
        System.out.println("\n____________After try with resources concept_____________\n");

        // using try with resources to open resouces (BufferReader, FileReader) which are of
        // AutoCloseable type
        try(BufferedReader br2 = new BufferedReader(new FileReader("new.txt"))){

            // once the code reaches to the end of try block
            // all the opened resources which are opened using try with resources
            // will be closed explicitly and one doesn't need to close it
            // explicitly inside finally block

            // this makes code more readable and shorter in length
        }
        catch(IOException e){
            // handling IOException
            e.printStackTrace();
        }
        // no need to use finally block to close opened resources





        // ____________________________________________________________________________________
        
        System.out.println("\n____________try with multiple resources_____________\n");

        // using try with resources to open multiple resources
        try(FileReader fr = new FileReader("new.txt"); PrintWriter pw = new PrintWriter("new.txt")){

            // all the opened resouces will be closed explicitly
            // Moreover, one cannot reassign reference variables of resources opened as a part
            // of try block
        }
        catch(IOException e){
            // handling IOException
            e.printStackTrace();
        }
        // no need to use finally block to close opened resources




        // ____________________________________________________________________________________
        
        System.out.println("\n____________try without catch or finally_____________\n");

        // using try with resources to open multiple resources
        try(FileReader fr = new FileReader("new.txt"); PrintWriter pw = new PrintWriter("new.txt")){

            // all the opened resouces will be closed explicitly
            // Moreover, one cannot reassign reference variables of resources opened as a part
            // of try block
        }
        // no need to use catch or finally block
        // but it won't prevent from abnormal termination of method
    }
}