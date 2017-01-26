package lambda_expression;

public class LE15 {
    private static int i = 10;
    
    public static void main(String[] args) {
        int y = 10;
        final int j = 10;
        int z = m1((x) -> j);
        y = m1((x) -> x + y + z);
        System.out.println(y);
    }
    
    static int m1(FI f) {
        return f.exec(i);
    }
    
    @FunctionalInterface
    interface FI {
        int exec(int i);
    }
}
