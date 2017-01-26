package lambda_expression;

public class LE13 {
    private int i = 100;
    
    public static void main(String[] args) {
        new LE13().m1();
    }
    
    void m1() {
        System.out.println(i);
        m2(() -> this.i = 200);
        System.out.println(i);
    }
    
    void m2(FI f) {
        f.exec();
    }
    
    @FunctionalInterface
    interface FI {
        void exec();
    }
}
