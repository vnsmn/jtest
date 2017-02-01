[![][back]](../README.md#lmb)
# 15.27 Lambda Expressions     

### COMPILE-ERROR   
-----     
#### 15.27 Lambda Expressions    
***    

 
### Question 2.2
    
    
[![][code]](LE2.java "code")<a href="http://localhost:8080/jexecutor/editor?path=expression/lambda_expression/LE2.java" title="exec" target="_blank">![][play]</a>
```java
package lambda_expression;

public class LE2 {
    public static void main(String[] args) {
        int i = 1;
        (i1) -> i1 + i;
        System.out.println(((FI) (i1) -> i1 + i).get(1));
    }
    
    @FunctionalInterface
    interface FI {
        Integer get(int i);
    }
}

```
<details markdown="1">
<summary><strong markdown="1" title="1">![][key]</strong></summary>
![][yes] *Compile-error*<br>It is a compile-time error if a lambda expression occurs in a program in someplace other than an assignment      
context (§5.2), an invocation context (§5.3), or a casting context (§5.5).         
<pre>
    LE2.java:11: error: not a statement     
    (i1) -> i1 + i;     
    ^     
    1 error     
</pre><a href="LE2.java" target="_blank" title="code">![][code]</a>
</details>
##### [![][cerr] see LE2.java](/home/vns/workspace/projects/portfolio/github/java/jtest/core/expression/lambda_expression/readme.md#LE2.java)
-----        
 
### Question 3.3
    
    
[![][code]](LE3.java "code")<a href="http://localhost:8080/jexecutor/editor?path=expression/lambda_expression/LE3.java" title="exec" target="_blank">![][play]</a>
```java
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

```
<details markdown="1">
<summary><strong markdown="1" title="1">![][key]</strong></summary>
![][yes] *Compile-error*<br>Lambda expressions cannot declare type parameters.<br><a href="LE3.java" target="_blank" title="code">![][code]</a>
</details>
##### [![][cerr] see LE3.java](/home/vns/workspace/projects/portfolio/github/java/jtest/core/expression/lambda_expression/readme.md#LE3.java)
-----        
 
### Question 4.4
    
    
[![][code]](LE4.java "code")<a href="http://localhost:8080/jexecutor/editor?path=expression/lambda_expression/LE4.java" title="exec" target="_blank">![][play]</a>
```java
package lambda_expression;

public class LE4 {
    public static void main(String[] args) {
        Integer d = 1;
        int i1 = (int) +d; //1
        Integer i2 = (Integer) +d; //2
        System.out.println(i1 + i2);
    }
}

```
<details markdown="1">
<summary><strong markdown="1" title="2">![][key]</strong></summary>
![][yes] *Compile-error in 2*<br>There is a precedent for ambiguity resolution involving casts, which essentially prohibits the use of - and + following a non-primitive cast (§15.15),     
but to extend that approach to generic lambdas would involve invasive changes to the grammar.<br><a href="LE4.java" target="_blank" title="code">![][code]</a>
</details>
##### [![][cerr] see LE4.java](/home/vns/workspace/projects/portfolio/github/java/jtest/core/expression/lambda_expression/readme.md#LE4.java)
-----        
#### 15.27.1. Lambda Parameters    
***    

 
### Question 5.5
    
    
[![][code]](LE10.java "code")<a href="http://localhost:8080/jexecutor/editor?path=expression/lambda_expression/LE10.java" title="exec" target="_blank">![][play]</a>
```java
package lambda_expression;

public class LE10 {
    public static void main(String[] args) {
        FI f = (_) -> _;
        System.out.println(f.get(1));
    }
    
    @FunctionalInterface
    interface FI {
        int get(Integer i1);
    }
}

```
<details markdown="1">
<summary><strong markdown="1" title="1">![][key]</strong></summary>
![][yes] *Compile-error*<br>It is a compile-time error if a lambda parameter has the name _ (that is, a single underscore character).<br><a href="LE10.java" target="_blank" title="code">![][code]</a>
</details>
##### [![][cerr] see LE10.java](/home/vns/workspace/projects/portfolio/github/java/jtest/core/expression/lambda_expression/readme.md#LE10.java)
-----        
 
### Question 6.6
    
    
[![][code]](LE11.java "code")<a href="http://localhost:8080/jexecutor/editor?path=expression/lambda_expression/LE11.java" title="exec" target="_blank">![][play]</a>
```java
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

```
<details markdown="1">
<summary><strong markdown="1" title="1">![][key]</strong></summary>
![][yes] *Compile-error*<br>When the parameter types of a lambda expression are inferred, the same lambda body can     
be interpreted in different ways, depending on the context in which it appears. Specifically,     
the types of expressions in the body, the checked exceptions thrown by the body, and the     
type correctness of code in the body all depend on the parameters' inferred types. This     
implies that inference of parameter types must occur "before" attempting to type-check the     
body of the lambda expression.<br><a href="LE11.java" target="_blank" title="code">![][code]</a>
</details>
##### [![][cerr] see LE11.java](/home/vns/workspace/projects/portfolio/github/java/jtest/core/expression/lambda_expression/readme.md#LE11.java)
-----        
 
### Question 7.7
    
    
[![][code]](LE12.java "code")<a href="http://localhost:8080/jexecutor/editor?path=expression/lambda_expression/LE12.java" title="exec" target="_blank">![][play]</a>
```java
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

```
<details markdown="1">
<summary><strong markdown="1" title="1">![][key]</strong></summary>
![][yes] *Compile-error*<br>When the parameter types of a lambda expression are inferred, the same lambda body can     
be interpreted in different ways, depending on the context in which it appears. Specifically,     
the types of expressions in the body, the checked exceptions thrown by the body, and the     
type correctness of code in the body all depend on the parameters' inferred types. This     
implies that inference of parameter types must occur "before" attempting to type-check the     
body of the lambda expression.     
<pre>
To check for applicability, the types of an invocation's arguments cannot, in general, be inputs to the analysis.      
This is because:     
• The arguments to a method invocation may be poly expressions     
• Poly expressions cannot be typed in the absence of a target type     
• Overload resolution has to be completed before the arguments' target types will be known     
</pre><a href="LE12.java" target="_blank" title="code">![][code]</a>
</details>
##### [![][cerr] see LE12.java](/home/vns/workspace/projects/portfolio/github/java/jtest/core/expression/lambda_expression/readme.md#LE12.java)
-----        
 
### Question 8.8
    
    
[![][code]](LE19.java "code")<a href="http://localhost:8080/jexecutor/editor?path=expression/lambda_expression/LE19.java" title="exec" target="_blank">![][play]</a>
```java
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

```
<details markdown="1">
<summary><strong markdown="1" title="2">![][key]</strong></summary>
![][yes] *Compile-error in 2*<br>It is a compile-time error to use mixed array notation (§10.2) for a variable arity parameter.     
<pre>
LE19.java:6: error: legacy array notation not allowed on variable-arity parameter     
        FI1 f2 = (Integer... x1[]) -> x1.length; //2     
                               ^     
1 error     
</pre><a href="LE19.java" target="_blank" title="code">![][code]</a>
</details>
##### [![][cerr] see LE19.java](/home/vns/workspace/projects/portfolio/github/java/jtest/core/expression/lambda_expression/readme.md#LE19.java)
-----        
 
### Question 9.9
    
    
[![][code]](LE5.java "code")<a href="http://localhost:8080/jexecutor/editor?path=expression/lambda_expression/LE5.java" title="exec" target="_blank">![][play]</a>
```java
package lambda_expression;

public class LE5 {
    public static void main(String[] args) {
        FI f = (x, Double y) -> x + y;
        System.out.println(f.get(1, 1.0));
    }
    
    interface FI {
        Double get(Integer i, Double d);
    }
}

```
<details markdown="1">
<summary><strong markdown="1" title="1">![][key]</strong></summary>
![][yes] *Compile-error*<br>The formal parameters of a lambda expression may have either declared types or inferred types.          
These styles cannot be mixed: it is not possible for a lambda expression to declare the types of some of its parameters but leave others to be inferred.<br><a href="LE5.java" target="_blank" title="code">![][code]</a>
</details>
##### [![][cerr] see LE5.java](/home/vns/workspace/projects/portfolio/github/java/jtest/core/expression/lambda_expression/readme.md#LE5.java)
-----        
 
### Question 10.10
    
    
[![][code]](LE6.java "code")<a href="http://localhost:8080/jexecutor/editor?path=expression/lambda_expression/LE6.java" title="exec" target="_blank">![][play]</a>
```java
package lambda_expression;

public class LE6 {
    public static void main(String[] args) {
        FI f = (x, final y) -> x + y;
        System.out.println(f.get(1, 1.0));
    }
    
    interface FI {
        Double get(Integer i, Double d);
    }
}

```
<details markdown="1">
<summary><strong markdown="1" title="1">![][key]</strong></summary>
![][yes] *Compile-error*<br>Only parameters with declared types can have modifiers.<br><a href="LE6.java" target="_blank" title="code">![][code]</a>
</details>
##### [![][cerr] see LE6.java](/home/vns/workspace/projects/portfolio/github/java/jtest/core/expression/lambda_expression/readme.md#LE6.java)
-----        
 
### Question 12.12
    
    
[![][code]](LE8.java "code")<a href="http://localhost:8080/jexecutor/editor?path=expression/lambda_expression/LE8.java" title="exec" target="_blank">![][play]</a>
```java
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

```
<details markdown="1">
<summary><strong markdown="1" title="1">![][key]</strong></summary>
![][yes] *Compile-error*<br>It is a compile-time error if a receiver parameter (§8.4.1) appears in the FormalParameters of a lambda expression.<br><a href="LE8.java" target="_blank" title="code">![][code]</a>
</details>
##### [![][cerr] see LE8.java](/home/vns/workspace/projects/portfolio/github/java/jtest/core/expression/lambda_expression/readme.md#LE8.java)
-----        
 
### Question 13.13
    
    
[![][code]](LE9.java "code")<a href="http://localhost:8080/jexecutor/editor?path=expression/lambda_expression/LE9.java" title="exec" target="_blank">![][play]</a>
```java
package lambda_expression;

public class LE9 {
    public static void main(String[] args) {
        FI f = (x, x) -> x;
        System.out.println(f.get(1, 1));
    }
    
    @FunctionalInterface
    interface FI {
        int get(Integer i1, Integer i2);
    }
}

```
<details markdown="1">
<summary><strong markdown="1" title="1">![][key]</strong></summary>
![][yes] *Compile-error*<br>It is a compile-time error for a lambda expression to declare two formal parameters with the same name.<br>(That is,      
their declarations mention the same Identifier.)<br><a href="LE9.java" target="_blank" title="code">![][code]</a>
</details>
##### [![][cerr] see LE9.java](/home/vns/workspace/projects/portfolio/github/java/jtest/core/expression/lambda_expression/readme.md#LE9.java)
-----        
#### 15.27.2. Lambda Body    
***    

 
### Question 15.15
    
    
[![][code]](LE14.java "code")<a href="http://localhost:8080/jexecutor/editor?path=expression/lambda_expression/LE14.java" title="exec" target="_blank">![][play]</a>
```java
package lambda_expression;

public class LE14 {
    private static int i = 100;
    
    public static void main(String[] args) {
        m1((i) -> { if (100 == i) return "done"; System.out.println("done"); });
    }
    
    static void m1(FI f) {
        System.out.println(f.exec(i));
    }
    
    @FunctionalInterface
    interface FI {
        String exec(int i);
    }
}

```
<details markdown="1">
<summary><strong markdown="1" title="1">![][key]</strong></summary>
![][yes] *Compile-error*<br>It is a compile-time error if a block lambda body is neither void-compatible nor value-compatible.<br><a href="LE14.java" target="_blank" title="code">![][code]</a>
</details>
##### [![][cerr] see LE14.java](/home/vns/workspace/projects/portfolio/github/java/jtest/core/expression/lambda_expression/readme.md#LE14.java)
-----        
 
### Question 16.16
    
    
[![][code]](LE15.java "code")<a href="http://localhost:8080/jexecutor/editor?path=expression/lambda_expression/LE15.java" title="exec" target="_blank">![][play]</a>
```java
package lambda_expression;

public class LE15 {
    private static int i = 10;
    
    public static void main(String[] args) {
        int y = 10;
        final int j = 10;
        int z = m1((x) -> j);
        y = m1((x) -> x + y + z);
        System.out.println(y);
    }
    
    static int m1(FI f) {
        return f.exec(i);
    }
    
    @FunctionalInterface
    interface FI {
        int exec(int i);
    }
}

```
<details markdown="1">
<summary><strong markdown="1" title="1">![][key]</strong></summary>
![][yes] *Compile-error*<br>Any local variable, formal parameter, or exception parameter used but not declared in a lambda expression must either be declared final or be effectively final (§4.12.4), or a compile-time error occurs where the use is attempted.<br><a href="LE15.java" target="_blank" title="code">![][code]</a>
</details>
##### [![][cerr] see LE15.java](/home/vns/workspace/projects/portfolio/github/java/jtest/core/expression/lambda_expression/readme.md#LE15.java)
-----        
 
### Question 17.17
    
    
[![][code]](LE16.java "code")<a href="http://localhost:8080/jexecutor/editor?path=expression/lambda_expression/LE16.java" title="exec" target="_blank">![][play]</a>
```java
package lambda_expression;

public class LE16 {
    private static int i = 10;
    
    public static void main(String[] args) {
        int y;
        int z = m1((x) -> x + y);
        System.out.println(z);
    }
    
    static int m1(FI f) {
        return f.exec(i);
    }
    
    @FunctionalInterface
    interface FI {
        int exec(int i);
    }
}

```
<details markdown="1">
<summary><strong markdown="1" title="1">![][key]</strong></summary>
![][yes] *Compile-error*<br>Any local variable used but not declared in a lambda body must be definitely assigned (§16 (Definite Assignment)) before the lambda body, or a compile-time error occurs.<br><a href="LE16.java" target="_blank" title="code">![][code]</a>
</details>
##### [![][cerr] see LE16.java](/home/vns/workspace/projects/portfolio/github/java/jtest/core/expression/lambda_expression/readme.md#LE16.java)
-----        
#### 15.27.3. Type of a Lambda Expression    
***    

 
### Question 18.18
    
    
[![][code]](LE17.java "code")<a href="http://localhost:8080/jexecutor/editor?path=expression/lambda_expression/LE17.java" title="exec" target="_blank">![][play]</a>
```java
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

```
<details markdown="1">
<summary><strong markdown="1" title="1">![][key]</strong></summary>
![][yes] *Compile-error*<br>If T is a wildcard-parameterized functional interface type and the lambda expression is implicitly typed, then the ground target type is the non-wildcard parameterization (§9.9) of T.<br><a href="LE17.java" target="_blank" title="code">![][code]</a>
</details>
##### [![][cerr] see LE17.java](/home/vns/workspace/projects/portfolio/github/java/jtest/core/expression/lambda_expression/readme.md#LE17.java)
-----        
 
### Question 21.21
    
    
[![][code]](LE21.java "code")<a href="http://localhost:8080/jexecutor/editor?path=expression/lambda_expression/LE21.java" title="exec" target="_blank">![][play]</a>
```java
package lambda_expression;

public class LE21 {
    public static void main(String[] args) {
        m1((n) -> n);
    }
    
    public static void m1(FI1 f) {
        System.out.print(1);
    }
    
    public static void m1(FI2 f) {
        System.out.print(2);
    }
    
    @FunctionalInterface
    interface FI1 {
        int get(int i);
    }

    @FunctionalInterface
    interface FI2 {
        Integer get(Integer i);
    }
}

```
<details markdown="1">
<summary><strong markdown="1" title="1">![][key]</strong></summary>
![][yes] *Compile-error*<br>However, if an explicitly typed lambda expression is an argument to an overloaded method,     
a method signature that avoids boxing or unboxing the lambda result is preferred by the most specific check     
(§15.12.2.5) - only explicitly typed lambda expression.     
<br><a href="LE21.java" target="_blank" title="code">![][code]</a>
</details>
##### [![][cerr] see LE21.java](/home/vns/workspace/projects/portfolio/github/java/jtest/core/expression/lambda_expression/readme.md#LE21.java)
-----        
#### 15.27.4. Run-Time Evaluation of Lambda Expressions    
***    

 
### Question 22.22
    
    
[![][code]](LE22.java "code")<a href="http://localhost:8080/jexecutor/editor?path=expression/lambda_expression/LE22.java" title="exec" target="_blank">![][play]</a>
```java
package lambda_expression;

public class LE22 {
    public static void main(String[] args) {
        m1((n) -> n);
    }
    
    public static void m1(FI1 f) {
        System.out.print(1);
    }
    
    public static void m1(FI2 f) {
        System.out.print(2);
    }
    
    @FunctionalInterface
    interface FI1 {
        Integer get(int i);
    }

    @FunctionalInterface
    interface FI2 extends FI1 {
        Integer get(int i);
    }
}

```
<details markdown="1">
<summary><strong markdown="1" title="1">![][key]</strong></summary>
![][yes] *Compile-error*<br>However, if an explicitly typed lambda expression is an argument to an overloaded method,     
a method signature that avoids boxing or unboxing the lambda result is preferred by the most specific check     
(§15.12.2.5) - only explicitly typed lambda expression.     
<br><a href="LE22.java" target="_blank" title="code">![][code]</a>
</details>
##### [![][cerr] see LE22.java](/home/vns/workspace/projects/portfolio/github/java/jtest/core/expression/lambda_expression/readme.md#LE22.java)
-----        
 
### Question 23.23
    
    
[![][code]](LE23.java "code")<a href="http://localhost:8080/jexecutor/editor?path=expression/lambda_expression/LE23.java" title="exec" target="_blank">![][play]</a>
```java
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

```
<details markdown="1">
<summary><strong markdown="1" title="1">![][key]</strong></summary>
![][yes] *Compile-error*<br>However, if an explicitly typed lambda expression is an argument to an overloaded method,     
a method signature that avoids boxing or unboxing the lambda result is preferred by the most specific check     
(§15.12.2.5) - only explicitly typed lambda expression.     
<br><a href="LE23.java" target="_blank" title="code">![][code]</a>
</details>
##### [![][cerr] see LE23.java](/home/vns/workspace/projects/portfolio/github/java/jtest/core/expression/lambda_expression/readme.md#LE23.java)
-----        
### RUNTIME-ERROR   
-----     
#### 15.27 Lambda Expressions    
***    

#### 15.27.1. Lambda Parameters    
***    

#### 15.27.2. Lambda Body    
***    

#### 15.27.3. Type of a Lambda Expression    
***    

#### 15.27.4. Run-Time Evaluation of Lambda Expressions    
***    

[![][back]](../README.md#lmb)

[key]: ../../resources/images/key.png
[help]: ../../resources/images/question-24.png
[code]: ../../resources/images/source-code-24.png
[back]: ../../resources/images/back-24.png
[play]: ../../resources/images/play-24.png
[result]: ../../resources/images/settings-16-1.png
[cerr]: ../../resources/images/compile-error-16.png
[rerr]: ../../resources/images/runtime-error-16.png
[yes]: ../../resources/images/yes-2-20.png