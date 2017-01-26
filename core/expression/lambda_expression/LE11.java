package lambda_expression;

public class LE11 {
    public static void main(String[] args) {
        FI1 f1 = (x) -> x.m1();
        FI2 f2 = (x) -> x.m1();
    }
    
    @FunctionalInterface
    interface FI1 {
        void exec(C1 arg);
    }
    
    @FunctionalInterface
    interface FI2 {
        void exec(C2 arg);
    }
    
    static class C1 {
        void m1() throws Exception {
        }
    }
    
    static class C2 {
        void m1() {
        }
    }
}
