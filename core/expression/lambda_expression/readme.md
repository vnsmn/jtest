
### [![][cerr] ERROR](https://github.com/vnsmn/jtest/blob/master/core/expression/lambda_expression/error.md)
        
### [![][key] ANSWER](https://github.com/vnsmn/jtest/blob/master/core/expression/lambda_expression/answer.md)
-----        
[![][back]](../README.md#lmb)
# 15.27 Lambda Expressions     
### 15.27 Lambda Expressions    
***    
<a name="LE1.java"></a>    
### Question 1.1
#### *Choose the correct answer:*
> `1.` *Compile-error*     
> `2.` *Runtime-error*     
> `3.` *Output: 234*     
    
[![][code]](LE1.java "code")<a href="http://localhost:8080/jexecutor/editor?path=expression/lambda_expression/LE1.java" title="exec" target="_blank">![][play]</a>
```java
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

```
<details markdown="1">
<summary><strong markdown="1" title="3">![][key]</strong></summary>
![][yes] *Output: 234*<br>A lambda expression occurs in an assignment context (§5.2), an invocation context (§5.3), or a casting context (§5.5).<br><a href="LE1.java" target="_blank" title="code">![][code]</a>
</details>
<details markdown="1">
<summary><strong markdown="1" title="compile result">![][result]</strong></summary>
<pre>
</pre></details>
###### *see*: [15.27](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27), [1](../../resources/docs/jls-15.html#le1)
***    
<a name="LE2.java"></a>    
### Question 2.2
#### *Choose the correct answer:*
> `1.` *Compile-error*     
> `2.` *Runtime-error*     
> `3.` *Output: 2*     
    
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
<details markdown="1">
<summary><strong markdown="1" title="compile result">![][result]</strong></summary>
<pre>
</pre></details>
###### *see*: [15.27](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27), [1](../../resources/docs/jls-15.html#le1)
***    
<a name="LE3.java"></a>    
### Question 3.3
#### *Choose the correct answer:*
> `1.` *Compile-error*     
> `2.` *Runtime-error*     
> `3.` *Output: 1*     
    
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
<details markdown="1">
<summary><strong markdown="1" title="compile result">![][result]</strong></summary>
<pre>
</pre></details>
###### *see*: [15.27](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27), [1](../../resources/docs/jls-15.html#le3)
***    
<a name="LE4.java"></a>    
### Question 4.4
#### *Choose the correct answer:*
> `1.` *Compile-error in 1*     
> `2.` *Compile-error in 2*     
> `3.` *Runtime-error*     
> `4.` *Output: 2*     
    
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
<details markdown="1">
<summary><strong markdown="1" title="compile result">![][result]</strong></summary>
<pre>
</pre></details>
###### *see*: [15.27](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27), [1](../../resources/docs/jls-15.html#le4)
***    
### 15.27.1. Lambda Parameters    
***    
<a name="LE10.java"></a>    
### Question 5.5
#### *Choose the correct answer:*
> `1.` *Compile-error*     
> `2.` *Runtime-error*     
> `3.` *The result is 1*     
    
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
<details markdown="1">
<summary><strong markdown="1" title="compile result">![][result]</strong></summary>
<pre>
</pre></details>
###### *see*: [15.27.1](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.1), [1](../../resources/docs/jls-15.html#le10)
***    
<a name="LE11.java"></a>    
### Question 6.6
#### *Choose the correct answer:*
> `1.` *Compile-error*     
> `2.` *Runtime-error*     
> `3.` *Successfully*     
    
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
<details markdown="1">
<summary><strong markdown="1" title="compile result">![][result]</strong></summary>
<pre>
</pre></details>
###### *see*: [15.27.1](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.1), [1](../../resources/docs/jls-15.html#le11)
***    
<a name="LE12.java"></a>    
### Question 7.7
#### *Choose the correct answer:*
> `1.` *Compile-error*     
> `2.` *Runtime-error*     
> `3.` *Successfully*     
    
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
<details markdown="1">
<summary><strong markdown="1" title="compile result">![][result]</strong></summary>
<pre>
</pre></details>
###### *see*: [15.27.1](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.1), [15.12.2](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.12.2), [1](../../resources/docs/jls-15.html#le11), [2](../../resources/docs/jls-15.html#le12)
***    
<a name="LE19.java"></a>    
### Question 8.8
#### *Choose the correct answer:*
> `1.` *Compile-error in 1*     
> `2.` *Compile-error in 2*     
> `3.` *Compile-error in 3*     
> `4.` *Runtime-error*     
> `5.` *Output: 000*     
    
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
<details markdown="1">
<summary><strong markdown="1" title="compile result">![][result]</strong></summary>
<pre>
</pre></details>
###### *see*: [15.27](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.1-320), [1](../../resources/docs/jls-15.html#le19)
***    
<a name="LE5.java"></a>    
### Question 9.9
#### *Choose the correct answer:*
> `1.` *Compile-error*     
> `2.` *Runtime-error*     
> `3.` *Output: 2.0*     
    
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
<details markdown="1">
<summary><strong markdown="1" title="compile result">![][result]</strong></summary>
<pre>
</pre></details>
###### *see*: [15.27.1](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.1), [1](../../resources/docs/jls-15.html#le5)
***    
<a name="LE6.java"></a>    
### Question 10.10
#### *Choose the correct answer:*
> `1.` *Compile-error*     
> `2.` *Runtime-error*     
> `3.` *Output: 2.0*     
    
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
<details markdown="1">
<summary><strong markdown="1" title="compile result">![][result]</strong></summary>
<pre>
</pre></details>
###### *see*: [15.27.1](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.1), [1](../../resources/docs/jls-15.html#le5)
***    
<a name="LE7.java"></a>    
### Question 11.11
#### *Choose the correct answer:*
> `1.` *Compile-error*     
> `2.` *Runtime-error*     
> `3.` *Output: 0*     
    
[![][code]](LE7.java "code")<a href="http://localhost:8080/jexecutor/editor?path=expression/lambda_expression/LE7.java" title="exec" target="_blank">![][play]</a>
```java
package lambda_expression;

public class LE7 {
    public static void main(String[] args) {
        FI f = (Integer[] x, Integer[] y, Integer... z) -> x.length + y.length;
        System.out.println(f.get(new Integer[]{}, new Integer[]{}));
    }
    
    interface FI {
        int get(Integer[] i1, Integer[] i2, Integer... i3);
    }
}

```
<details markdown="1">
<summary><strong markdown="1" title="3">![][key]</strong></summary>
![][yes] *Output: 0*<br>In a lambda body, a variable arity parameter is treated just like an array-typed parameter.<br><a href="LE7.java" target="_blank" title="code">![][code]</a>
</details>
<details markdown="1">
<summary><strong markdown="1" title="compile result">![][result]</strong></summary>
<pre>
</pre></details>
###### *see*: [15.27.1](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.1), [1](../../resources/docs/jls-15.html#le5)
***    
<a name="LE8.java"></a>    
### Question 12.12
#### *Choose the correct answer:*
> `1.` *Compile-error*     
> `2.` *Runtime-error*     
> `3.` *Output: 1*     
    
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
<details markdown="1">
<summary><strong markdown="1" title="compile result">![][result]</strong></summary>
<pre>
</pre></details>
###### *see*: [15.27.1](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.1), [1](../../resources/docs/jls-15.html#le8)
***    
<a name="LE9.java"></a>    
### Question 13.13
#### *Choose the correct answer:*
> `1.` *Compile-error*     
> `2.` *Runtime-error*     
> `3.` *Output: 2*     
    
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
<details markdown="1">
<summary><strong markdown="1" title="compile result">![][result]</strong></summary>
<pre>
</pre></details>
###### *see*: [15.27](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.1), [1](../../resources/docs/jls-15.html#le9)
***    
### 15.27.2. Lambda Body    
***    
<a name="LE13.java"></a>    
### Question 14.14
#### *Choose the correct answer:*
> `1.` *Compile-error*     
> `2.` *Runtime-error*     
> `3.` *Output: <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;100<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;100*     
> `4.` *Output: <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;100<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;200*     
    
[![][code]](LE13.java "code")<a href="http://localhost:8080/jexecutor/editor?path=expression/lambda_expression/LE13.java" title="exec" target="_blank">![][play]</a>
```java
package lambda_expression;

public class LE13 {
    private int i = 100;
    
    public static void main(String[] args) {
        new LE13().m1();
    }
    
    void m1() {
        System.out.println(i);
        m2(() -> this.i = 200);
        System.out.println(i);
    }
    
    void m2(FI f) {
        f.exec();
    }
    
    @FunctionalInterface
    interface FI {
        void exec();
    }
}

```
<details markdown="1">
<summary><strong markdown="1" title="4">![][key]</strong></summary>
![][yes] *Output: <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;100<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;200*<br>Unlike code appearing in anonymous class declarations, the meaning of names and the this and super keywords appearing in a lambda body, along with the accessibility of referenced declarations, are the same as in the surrounding context (except that lambda parameters introduce new names).<br><a href="LE13.java" target="_blank" title="code">![][code]</a>
</details>
<details markdown="1">
<summary><strong markdown="1" title="compile result">![][result]</strong></summary>
<pre>
</pre></details>
###### *see*: [15.27.2](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.2), [1](../../resources/docs/jls-15.html#le13)
***    
<a name="LE14.java"></a>    
### Question 15.15
#### *Choose the correct answer:*
> `1.` *Compile-error*     
> `2.` *Runtime-error*     
> `3.` *Output: done*     
    
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
<details markdown="1">
<summary><strong markdown="1" title="compile result">![][result]</strong></summary>
<pre>
</pre></details>
###### *see*: [15.27.2](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.2), [1](../../resources/docs/jls-15.html#le14)
***    
<a name="LE15.java"></a>    
### Question 16.16
#### *Choose the correct answer:*
> `1.` *Compile-error*     
> `2.` *Runtime-error*     
> `3.` *Output: 30*     
    
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
<details markdown="1">
<summary><strong markdown="1" title="compile result">![][result]</strong></summary>
<pre>
</pre></details>
###### *see*: [15.27.2](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.2), [1](../../resources/docs/jls-15.html#le15)
***    
<a name="LE16.java"></a>    
### Question 17.17
#### *Choose the correct answer:*
> `1.` *Compile-error*     
> `2.` *Runtime-error*     
> `3.` *Output: 10*     
    
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
<details markdown="1">
<summary><strong markdown="1" title="compile result">![][result]</strong></summary>
<pre>
</pre></details>
###### *see*: [15.27.2](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.2-310), [1](../../resources/docs/jls-15.html#le16)
***    
### 15.27.3. Type of a Lambda Expression    
***    
<a name="LE17.java"></a>    
### Question 18.18
#### *Choose the correct answer:*
> `1.` *Compile-error*     
> `2.` *Runtime-error*     
> `3.` *Output: 5*     
    
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
<details markdown="1">
<summary><strong markdown="1" title="compile result">![][result]</strong></summary>
<pre>
</pre></details>
###### *see*: [15.27.3](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.3-200-B), [1](../../resources/docs/jls-15.html#le17)
***    
<a name="LE18.java"></a>    
### Question 19.19
#### *Choose the correct answer:*
> `1.` *Compile-error*     
> `2.` *Runtime-error*     
> `3.` *Output: 5*     
    
[![][code]](LE18.java "code")<a href="http://localhost:8080/jexecutor/editor?path=expression/lambda_expression/LE18.java" title="exec" target="_blank">![][play]</a>
```java
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

```
<details markdown="1">
<summary><strong markdown="1" title="3">![][key]</strong></summary>
![][yes] *Output: 5*<br>If T is a wildcard-parameterized functional interface type and the lambda expression is implicitly typed,     
then the ground target type is the non-wildcard parameterization (§9.9) of T.<br><a href="LE18.java" target="_blank" title="code">![][code]</a>
</details>
<details markdown="1">
<summary><strong markdown="1" title="compile result">![][result]</strong></summary>
<pre>
</pre></details>
###### *see*: [15.27.3](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.3-200-B), [1](../../resources/docs/jls-15.html#le17)
***    
<a name="LE20.java"></a>    
### Question 20.20
#### *Choose the correct answer:*
> `1.` *Compile-error*     
> `2.` *Runtime-error*     
> `3.` *Output: 12*     
> `4.` *Output: 21*     
    
[![][code]](LE20.java "code")<a href="http://localhost:8080/jexecutor/editor?path=expression/lambda_expression/LE20.java" title="exec" target="_blank">![][play]</a>
```java
package lambda_expression;

public class LE20 {
    public static void main(String[] args) {
        m1((Integer n) -> n);
        m1((int n) -> n);
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
<summary><strong markdown="1" title="4">![][key]</strong></summary>
![][yes] *Output: 21*<br>However, if an explicitly typed lambda expression is an argument to an overloaded method,     
a method signature that avoids boxing or unboxing the lambda result is preferred by the most specific check(§15.12.2.5).<br><a href="LE20.java" target="_blank" title="code">![][code]</a>
</details>
<details markdown="1">
<summary><strong markdown="1" title="compile result">![][result]</strong></summary>
<pre>
</pre></details>
###### *see*: [15.27.3](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.3), [1](../../resources/docs/jls-15.html#le20)
***    
<a name="LE21.java"></a>    
### Question 21.21
#### *Choose the correct answer:*
> `1.` *Compile-error*     
> `2.` *Runtime-error*     
> `3.` *Output: 12*     
> `4.` *Output: 21*     
    
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
![][yes] *Compile-error*<br>Certain argument expressions that contain implicitly typed lambda expressions (§15.27.1) or inexact method references (§15.13.1) are ignored by the applicability tests,     
because their meaning cannot be determined until a target type is selected.     
     
However, if an explicitly typed lambda expression is an argument to an overloaded method,     
a method signature that avoids boxing or unboxing the lambda result is preferred by the most specific check     
(§15.12.2.5) - only explicitly typed lambda expression.     
<br><a href="LE21.java" target="_blank" title="code">![][code]</a>
</details>
<details markdown="1">
<summary><strong markdown="1" title="compile result">![][result]</strong></summary>
<pre>
</pre></details>
###### *see*: [LE20](#LE20.java), [LE12](#LE12.java), [15.27.3](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.3), [1](../../resources/docs/jls-15.html#le20), [2](../../resources/docs/jls-15.html#le11), [3](../../resources/docs/jls-15.html#le12), [4](../../resources/docs/jls-15.html#le21)
***    
### 15.27.4. Run-Time Evaluation of Lambda Expressions    
***    
<a name="LE22.java"></a>    
### Question 22.22
#### *Choose the correct answer:*
> `1.` *Compile-error*     
> `2.` *Runtime-error*     
> `3.` *Output: 12*     
> `4.` *Output: 21*     
    
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
<details markdown="1">
<summary><strong markdown="1" title="compile result">![][result]</strong></summary>
<pre>
</pre></details>
###### *see*: [see LE20](#LE20.java), [see LE12](#LE12.java), [15.27.3](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.3), [1](../../resources/docs/jls-15.html#le20), [2](../../resources/docs/jls-15.html#le11), [3](../../resources/docs/jls-15.html#le12)
***    
<a name="LE23.java"></a>    
### Question 23.23
#### *Choose the correct answer:*
> `1.` *Compile-error*     
> `2.` *Runtime-error*     
> `3.` *Output: 12*     
> `4.` *Output: 21*     
    
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
![][yes] *Compile-error*<br>When the parameter types of a lambda expression are inferred, the same lambda body can be ...<sup>[[1]](https://rawgit.com/vnsmn/jtest/master/core/resources/docs/jls-15.html#le11)</sup><br>     
Overload resolution has to be completed before the arguments' target types will be known<sup>[[2]](https://rawgit.com/vnsmn/jtest/master/core/resources/docs/jls-15.html#le12)</sup><br>     
Note that while boxing is not allowed in a strict invocation context, boxing of lambda result expressions is always allowed - that is, the result expression appears in an assignment context, regardless of the context enclosing the lambda expression. However, if an explicitly typed lambda expression is an argument to an overloaded method, a method signature that avoids boxing or unboxing the lambda result is preferred by the most specific check (§15.12.2.5).<sup>[[3]](https://rawgit.com/vnsmn/jtest/master/core/resources/docs/jls-15.html#le20)</sup><br><a href="LE23.java" target="_blank" title="code">![][code]</a>
</details>
<details markdown="1">
<summary><strong markdown="1" title="compile result">![][result]</strong></summary>
<pre>
</pre></details>
###### *see*: [see LE20](#LE20.java), [see LE12](#LE12.java), [15.27.3](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.3), [1](https://rawgit.com/vnsmn/jtest/master/core/resources/docs/jls-15.html#le20), [2](https://rawgit.com/vnsmn/jtest/master/core/resources/docs/jls-15.html#le11), [3](https://rawgit.com/vnsmn/jtest/master/core/resources/docs/jls-15.html#le12)
***    

### [![][cerr] ERROR](https://github.com/vnsmn/jtest/blob/master/core/expression/lambda_expression/error.md)
        
### [![][key] ANSWER](https://github.com/vnsmn/jtest/blob/master/core/expression/lambda_expression/answer.md)
-----        

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