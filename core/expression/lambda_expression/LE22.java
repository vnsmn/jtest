package lambda_expression;

public class LE22 {
    public static void main(String[] args) {
        m1((n) -> n);
    }
    
    public static void m1(FI1 f) {
        System.out.print(1);
    }
    
    public static void m1(FI2 f) {
        System.out.print(2);
    }
    
    @FunctionalInterface
    interface FI1 {
        Integer get(int i);
    }

    @FunctionalInterface
    interface FI2 extends FI1 {
        Integer get(int i);
    }
}
