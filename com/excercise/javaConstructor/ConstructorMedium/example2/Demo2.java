

class Parent {

    /*  
        parent constructor throws RuntimeException (Unchecked Exception) which is not
        required to handled by child constructor
    */
    Parent(int i) throws RuntimeException {

    }
}

class Child extends Parent {

    /* 
        child constructor not handling RuntimeException (Unchecked Exception) thrown
        by parent class constructor 
    */
    Child() {

        super(10);
    }
}


public class Demo2 {
    
    public static void main(String[] args) {
        
    }
}