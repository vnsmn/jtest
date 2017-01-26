package lambda_expression;

public class LE12 {
    public static void main(String[] args) {
        m2((x) -> x.m1());
        
    }
    
    static void m2(FI1 fi1) {
        fi1.exec(new C1()); //The target type is known after overlaod resolution 
    }
    
    static void m2(FI2 fi2) {
        fi2.exec(new C2()); //The target type is known after overlaod resolution
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
        void m1() {
        }
    }
    
    static class C2 {
        void m1() {
        }
    }
}
