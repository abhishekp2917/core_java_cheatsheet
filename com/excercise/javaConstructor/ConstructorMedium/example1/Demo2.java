class Parent {
    
    // parent constructor with int varargs argument
   Parent(int... i) {

   }
}

class Child extends Parent {
    
    // not calling parent constructor but compiler will add no-argument constructor
    Child() {
        
    }
}


public class Demo2 {
    
    public static void main(String[] args) {
        
    }
}
