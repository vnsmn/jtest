package lambda_expression;

import java.util.ArrayList;
import java.util.List;

public class LE18 {
    
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        FI<?> f = (x) -> {
            x.add(1);
            List<Object> list = x;
            list.add("");
            return x;
        };
        f.exec((List) l);
        System.out.println(l.size());
    }
    
    @FunctionalInterface
    interface FI<T> {
        T exec(List<T> arg);
    }
}
