package com.excercise.javaEnum;


// declaring enum 'Tiger'
enum Tiger{
    Siberian,
    Bengal,
    African;

    // creating enum 'Tiger' constructor
    Tiger(){
        // print the string whenever Tiger constructor is executed
        System.out.println("Enum constructor executed");
    }
}


enum Bird{

    // create Bird object by calling Bird constructor
    Peacock("Blue", "Big", 100.5f),
    Peigon("Grey", "Small", 20f),
    Parrot("Green", "small", 40.0f),
    Swan("White", "Medium", 70.9f),
    // create Bird object by calling default constructor
    Crow;

    // enum normal private variables
    private String color;
    private String size;
    private float price;

    // enum static constant 
    public static final String COUNTRY = "India";

    // enum constructor
    Bird(String color, String size, float price){
        this.color = color;
        this.size = size;
        this.price = price;
    }

    // constructor overloading
    // default constructor
    Bird(){
        this.color = "Black";
        this.size = "Small";
        this.price = 10;
    }

    // enum methods to get value of enum normal variables
    public String getColor(){
        return color;
    }

    public String getSize(){
        return this.size;
    }

    public float getPrice(){
        return this.price;
    }
}

public class EnumConstructor {
    public static void main(String[] args){

        // assigning enum 'Tiger' value to variable t1
        // this will call Tiger constructor 'n' times where 'n' is the number of constants  
        Tiger t1 = Tiger.Bengal;
        System.out.println("Tiger is "+t1);

        // assigning enum Bird constant 
        Bird b1 = Bird.Peacock;
        Bird b2 = Bird.Crow;

        // printing enum constant and its normal variable values
        System.out.println(b1+" : "+b1.getColor()+" "+b1.getSize()+" "+b1.getPrice()+" "+Bird.COUNTRY);
        System.out.println(b2+" : "+b2.getColor()+" "+b2.getSize()+" "+b2.getPrice()+" "+Bird.COUNTRY);
    }
}
