package lambda_expression;

import java.util.ArrayList;
import java.util.List;

public class LE17 {
    
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        FI<?> f = (x) -> {
            List<Integer> list = x; //true is List<Object> list = x;
            list.add(1);
            return list.size();
        };
        System.out.println(l.size());
    }
    
    @FunctionalInterface
    interface FI<T> {
        T exec(List<T> arg);
    }
}
