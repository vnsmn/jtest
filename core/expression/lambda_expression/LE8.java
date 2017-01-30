package lambda_expression;

public class LE8 {
    
    public static void main(String[] args) {
        new LE8().test();
    }
    
    public void test() {
        FI f = (Integer this, Integer i) -> i;
        System.out.println(f.get(1, 1));
    }
    
    interface FI {
        int get(Integer i1, Integer i2);
    }
}
