package lambda_expression;

public class LE10 {
    public static void main(String[] args) {
        FI f = (_) -> _;
        System.out.println(f.get(1));
    }
    
    @FunctionalInterface
    interface FI {
        int get(Integer i1);
    }
}
