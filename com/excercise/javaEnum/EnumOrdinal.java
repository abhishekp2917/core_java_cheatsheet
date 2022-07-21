package com.excercise.javaEnum;

public class EnumOrdinal {

    // declaring enum 'Gender'  inside a class
    enum Gender{
        Male,
        Female,
        Other
    }
    public static void main(String[] args){

        // assigning enum 'Gender' value to variable of type 'Gender' 
        Gender g1 = Gender.Male;
        Gender g2 = Gender.Female;
        Gender g3 = Gender.Other;

        // printing values of variable of type 'Gender'
        System.out.println(g1+" "+g1.ordinal());
        System.out.println(g2+" "+g2.ordinal());
        System.out.println(g3+" "+g3.ordinal());

        // iterating over values of type Gender
        for(Gender g: Gender.values()){

            // using 'ordinal' method to get '0' indexed order of each enum value
            System.out.println(g+" "+g.ordinal());
        }
    }
}
