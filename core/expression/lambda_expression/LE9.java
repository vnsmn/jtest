package lambda_expression;

public class LE9 {
    public static void main(String[] args) {
        FI f = (x, x) -> x;
        System.out.println(f.get(1, 1));
    }
    
    @FunctionalInterface
    interface FI {
        int get(Integer i1, Integer i2);
    }
}
