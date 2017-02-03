package lambda_expression;

public class LE23 {
    public static void main(String[] args) {
        FI1 i = (FI1 & FI2) (int n) -> n;
        //m1((int n) -> n);
    }
    
    public static <T extends FI1 & FI2> void m1(T f) {
        f = (int n) -> n;
        System.out.print(((FI1) f).get(1));
        System.out.print(((FI2) f).get(2));
    }
    
    @FunctionalInterface
    interface FI1 {
        Integer get(int i);
    }
    
    @FunctionalInterface
    interface FI2 {
        Integer get(int i);
    }
}
