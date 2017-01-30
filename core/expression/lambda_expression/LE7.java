package lambda_expression;

public class LE7 {
    public static void main(String[] args) {
        FI f = (Integer[] x, Integer... y, Integer... z) -> x.length + y.length;
        System.out.println(f.get(new Integer[]{}, new Integer[]{}));
    }
    
    interface FI {
        int get(Integer[] i1, Integer[] i2, Integer... i3);
    }
}
