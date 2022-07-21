package com.excercise.javaInheritance.InheritanceMedium;

public class Pet {
    
    private String name;
    private float weight;
    private int eyes;
    
    Pet(String name, float weight, int eyes){
        this.weight = weight;
        this.name = name;
        this.eyes = eyes;
        System.out.println(this.hashCode());
    }

    public String getName(){
        return this.name;
    }

    public float getWeight(){
        return this.weight;
    }

    public int getEyes(){
        return this.eyes;
    }

    public void walk(int distance){
        System.out.println(this.getName()+" walks a distance of "+distance+"km.");
    }

    public void run(int distance){
        System.out.println(this.getName()+" runs a distance of "+distance+"km.");
    }
}
