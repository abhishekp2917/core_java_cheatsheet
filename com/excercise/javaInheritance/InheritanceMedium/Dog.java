package com.excercise.javaInheritance.InheritanceMedium;

public class Dog extends Pet{
    
    private String breed;
    private String country;
    private int legs;

    Dog(String name, float weight, int eyes, String breed, String country, int legs){
        super(name, weight, eyes);
        this.breed = breed;
        this.country = country;
        this.legs = legs;
        System.out.println(this.hashCode());
    }

    public String getCountry(){
        return this.country;
    }

    public String getBreed(){
        return this.breed;
    }

    public int getLegs(){
        return this.legs;
    }
}
