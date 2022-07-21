
public class Demo1 {
    
    public static void main(String[] args) {
        
        // calling static method which will give StackOverflowException
        method1();
    }

    // static method method1() which calls static method2()
    public static void method1() {
        method2();
    }

    // static method method2() which calls static method1() for creating recursive calls
    public static void method2() {
        method1();
    }
}
