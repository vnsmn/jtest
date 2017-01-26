package lambda_expression;

public class LE16 {
    private static int i = 10;
    
    public static void main(String[] args) {
        int y;
        int z = m1((x) -> x + y);
        System.out.println(z);
    }
    
    static int m1(FI f) {
        return f.exec(i);
    }
    
    @FunctionalInterface
    interface FI {
        int exec(int i);
    }
}
