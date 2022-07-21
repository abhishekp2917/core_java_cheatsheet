package com.excercise.javaEnum;

// creating user defined datatype 'Month' using enum keyword
enum Month{
    January,
    February,
    March,
    April,
    May,
    June,
    July,
    August,
    September,
    October,
    November,
    December;
    // ';' is optional in enum datatype
}

// empty enum datatype is also valid 
enum Job{ 

}

public class EnumBasics {

    // declaring enum inside a class is valid but not inside method 
    enum Weeks{
        Sunday,
        Monday,
        Tuesday,
        Wednesday,
        Thursday,
        Friday,
        Saturday
    }

    public static void main(String[] args){

        // declaring variable of type 'Month'
        Month m;
        // assigning value to variable of type 'Month'
        m = Month.January;

        // printing value of 'm'
        System.out.println(m);

        // ______________________________________________________________________________________


        Weeks w = Weeks.Saturday;

        // using enum inside switch
        switch(w){
            case Saturday: System.out.println("Today is a Holiday");
                            break;
            case Sunday: System.out.println("Today is a Holiday");
                            break;
            default : System.out.println("This is working day");
        }
    }
}
