package lambda_expression;

public class LE1 {
    public static void main(String[] args) {
        int i = 1;
        FI fi = (i1) -> i1 + i;
        System.out.print(fi.get(i));
        System.out.print(((FI) (i1) -> i1 + i).get(2));
        m1((i1) -> i1 + i);
    }
    
    static void m1(FI f) {
        System.out.print(f.get(3));
    }
    
    @FunctionalInterface
    interface FI {
        Integer get(int i);
    }
}
