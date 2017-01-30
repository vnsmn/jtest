package lambda_expression;

public class LE5 {
    public static void main(String[] args) {
        FI f = (x, Double y) -> x + y;
        System.out.println(f.get(1, 1.0));
    }
    
    interface FI {
        Double get(Integer i, Double d);
    }
}
