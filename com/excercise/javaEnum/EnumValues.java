package com.excercise.javaEnum;

public class EnumValues {

    // declaring enum 'Gender'  inside a class
    enum Gender{
        Male,
        Female,
        Other
    }

    public static void main(String[] args){

        // using values method to get all the values of enum 'Gender'
        Gender[] g1 = Gender.values();

        // iterating enum 'Gender' values 
        for(Gender g: g1){
            System.out.println(g);
        }
    }
}
