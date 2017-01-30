package lambda_expression;

public class LE20 {
    public static void main(String[] args) {
        m1((Integer n) -> n);
        m1((int n) -> n);
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
