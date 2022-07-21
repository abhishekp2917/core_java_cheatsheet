package com.excercise.javaAggregation.AggregationBasics.example1;

/* 
    Car class which has an owner object and thus having HAS-A realtionship with 
    Owner class

    Moreover, since Owner is a contained object here inside Car class (Container)
    and there is an existance of contained object without container
    object, there is a weak association between Car and Owner and thus it is
    an example of Aggregation
*/
public class Car {
    
    // car class has an owner but both are weakly associated
    // here an owner object will exist even if car object doesn't exists
    Owner carOwner;

    Car(Owner carOwner) {
        this.carOwner = carOwner;
    }
}
