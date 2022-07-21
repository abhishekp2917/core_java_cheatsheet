class Parent {
    
    // parent constructor with double argument
   Parent(double d) {

   }
}

class Child extends Parent {
    
    Child() {
        
        /* 
            calling parent constructor by passing int argument which will convert 
            into double due to argument promotion 
        */
        super(10);
    }
}


public class Demo3 {
    
    public static void main(String[] args) {
        
    }
}
