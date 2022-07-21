import java.io.IOException;

class Parent {

    /*  
        parent constructor throws IOException (Checked Exception) which must be 
        handled by child constructor
    */
    Parent(int i) throws IOException {

    }
}

class Child extends Parent {

    /* 
        child constructor handling IOException (Checked Exception) thrown by 
        parent class constructor 

        we can't use try-catch block to handle Checked Exception because first line
        in constructor must be either 'super()' or 'this()'
    */
    Child() throws IOException {

        super(10);
    }
}


public class Demo1 {
    
    public static void main(String[] args) {
        
    }
}
