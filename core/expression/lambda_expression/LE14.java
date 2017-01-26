package lambda_expression;

public class LE14 {
    private static int i = 100;
    
    public static void main(String[] args) {
        m1((i) -> { if (100 == i) return "done"; System.out.println("done"); });
    }
    
    static void m1(FI f) {
        System.out.println(f.exec(i));
    }
    
    @FunctionalInterface
    interface FI {
        String exec(int i);
    }
}
