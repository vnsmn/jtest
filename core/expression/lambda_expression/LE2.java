package lambda_expression;

public class LE2 {
    public static void main(String[] args) {
        int i = 1;
        (i1) -> i1 + i;
        System.out.println(((FI) (i1) -> i1 + i).get(1));
    }
    
    @FunctionalInterface
    interface FI {
        Integer get(int i);
    }
}
