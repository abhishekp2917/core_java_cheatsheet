package com.excercise.javaEnum;

// making enum public
public enum EnumSpeciality {
    
    // list of constants must be declared before extra member like method and must ends with ';'
    Star,
    Gold,
    Gummpy;

    // declaring main method inside enum
    public static void main(String[] args){

        System.out.println("Running Java main method");

        // iterating over enum values
        for(EnumSpeciality e: EnumSpeciality.values()){

            // printing enum values and its ordinal (order) value
            System.out.println(e + " "+ e.ordinal());
        }
    }
}
