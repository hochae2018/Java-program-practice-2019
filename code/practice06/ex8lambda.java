package practice06;

interface FuncInterface { 
    // An abstract function 
    void abstractFun(int x); 
  
    // A non-abstract (or default) function 
    default void normalFun() { 
       System.out.println("Hello"); 
    } 
} 

/**
 * ex8lambda
 */
public class ex8lambda {
    public static void main(String[] args) {
        //lambda expression to implement abstractFun()
        FuncInterface fobj = (int x)->System.out.println(2*x); 
        // This calls above lambda expression and prints 10. 
        fobj.abstractFun(5); 
    }
}

