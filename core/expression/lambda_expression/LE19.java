package lambda_expression;

public class LE19 {
    public static void main(String[] args) {
        FI1 f1 = (Integer[]... x1) -> x1.length; //1
        FI1 f2 = (Integer... x1[]) -> x1.length; //2
        FI2 f3 = (Integer x1[]) -> x1.length; //3
        System.out.print(f1.get(new Integer[0][0]));
        System.out.print(f2.get(new Integer[0][0]));
        System.out.print(f3.get(new Integer[0]));
    }
    
    @FunctionalInterface
    interface FI1 {
        int get(Integer[][] i1);
    }

    @FunctionalInterface
    interface FI2 {
        int get(Integer[] i1);
    }
}
