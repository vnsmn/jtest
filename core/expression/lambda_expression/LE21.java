package lambda_expression;

public class LE21 {
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
        int get(int i);
    }

    @FunctionalInterface
    interface FI2 {
        Integer get(Integer i);
    }
}
