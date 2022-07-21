package com.excercise.javaException;

// creating Student class
class Student{

}

public class ExceptionThrow {
    
    public static void main(String[] args){

        // _________________________________________________________________________________________________

        System.out.println("\n____________________Throw Exception object_______________\n");
        // creating ArithmeticException object with Exception description 'Division by Zero not acceptable'
        ArithmeticException exceptionObject1 = new ArithmeticException("Division by Zero not acceptable");

        try{
            // sending/ throwing ArithmeticException object to JVM
            // this will raise ArithmeticException
            throw exceptionObject1;
        }
        catch(ArithmeticException e){
            // consoling Exception information
            e.printStackTrace();
        }


        

        // _________________________________________________________________________________________________

        System.out.println("\n_________________________Throw null______________________\n");

        // creating ArithmeticException variable and assiging null value to it
        ArithmeticException exceptionObject2 = null;

        try{
            // sending/ throwing null to JVM
            // this will raise NullPointerException
            // throw exceptionObject2;
            System.out.println(exceptionObject2);
        }
        catch(NullPointerException e){
            // consoling Exception name and description
            System.out.println(e.toString());
        }




        // _________________________________________________________________________________________________

        System.out.println("\n________________Throw not Throwable object_______________\n");

        // creating student object
        Student s = new Student();

        try{
            System.out.println(s);
            // sending/ throwing student object to JVM which is not throwable
            // this will raise compile time error
            // throw s;
        }
        catch(Exception e){
            // consoling Exception name and description
            System.out.println(e.toString());
        }





        // _________________________________________________________________________________________________

        System.out.println("\n_____________Unreachable Statement after throw____________\n");

        // creating student object
        ArrayIndexOutOfBoundsException exceptionObject3 = new ArrayIndexOutOfBoundsException();

        try{
            // sending/ throwing ArrayIndexOutOfBoundsException object to JVM
            throw exceptionObject3;
            // this is unreachable and will raise compile time error
            // System.out.print("Unreachable statement");
        }
        catch(Exception e){
            // consoling Exception name and description
            System.out.println(e.toString());
        }

    }
}
