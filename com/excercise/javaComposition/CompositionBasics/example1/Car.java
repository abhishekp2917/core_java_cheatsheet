package com.excercise.javaComposition.CompositionBasics.example1;

/* 
    Car class which has an engine object and thus having HAS-A realtionship with 
    Engine class

    Moreover, since Engine is a contained object here inside Car class (Container)
    and there is no chance of existance of contained object without container
    object, there is a strong association between Car and Engine and thus it is
    an example of composition
*/
public class Car {
    
    // Car class has an Engine object and both are strongly associated
    Engine turboEngine = new Engine();
}
