package com.excercise.javaInterface;


// cars intrface
// interface can only be public or abstract
// interface doesn't have constructor as all the properties of interface are public, static and final by default
abstract interface Car{

    public static final int WHEELS = 4;

    // in interface, implementation for static method is required as static method is accessible through class name
    public static float getWheels(){
        return Car.convertToFloat(Car.WHEELS);
    }

    // interface can contain private static method as public static method is allowed and one can use this private static method in public static method
    private static float convertToFloat(int value){
        return value + 0.0f;
    }
    
    // all the interface methods are public and abstract by default  and one can change it only if the method is static
    abstract public void Charge(float timeInHr);
    abstract public void Drive(float distanceInKm);
}

// suv class implementing car interface
// as this class is not abstract or interface, implementation all the inherited methods must be given
class SUV implements Car{

    static String size = "Small";
    String brand;
    int seats;
    float speedInKmph;
    boolean isProtected;

    // suv class constructor
    SUV(String brand, int seats, float speedInKmph, boolean isProtected, String size){
        this.brand = brand;
        this.seats = seats;
        this.speedInKmph = speedInKmph;
        this.isProtected = isProtected;
        // static variable can be initialized by constructor
        this.size = size;
    };

    public void Charge(float timeInHr){
        System.out.println("Charge "+this.brand+" SUV for "+timeInHr+"hr");
    };

    public void Drive(float distanceInKm){
        System.out.println("Drive "+this.brand+" SUV for "+distanceInKm+"km");
    };

    public void setSize(String size){
        // static variable is accessible inside non-static method
        SUV.size = size;
    }
}






public class Interface {
    public static void main(String[] args){
        
        System.out.println(Car.getWheels());

        SUV suv1 = new SUV("Tata", 6, 150.5f, true, "Big");
        System.out.println(suv1.size);
        System.out.println(SUV.size);

    };
}
