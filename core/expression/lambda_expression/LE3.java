package lambda_expression;

public class LE3 {
    
    public static void main(String[] args) {
        foo((FI<Integer, Integer>) < Integer, Integer > (w) -> w);
        foo((w) -> w);
    }
    
    static void foo(FI<Integer, Integer> f) {
        System.out.println(f.get(1));
    }
    
    interface FI<T1, T2> {
        T2 get(T1 t);
    }
}
