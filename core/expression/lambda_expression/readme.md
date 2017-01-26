[![][back]](../README.md#lmb)
# 15.27 Lambda Expressions     
### 15.27 Lambda Expressions    
***    
    
### Question 1.1
#### *What is result?*
> `1.` *Compile-error*     
> `2.` *Runtime-error*     
> `3.` *The result is 234*     
    
[![][code]](LE1.java "code")
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
![][yes] *The result is 234*<br>A lambda expression occurs in an assignment context (§5.2), an invocation context (§5.3), or a casting context (§5.5).<br><a href="LE1.java" target="_blank" title="code">![][code]</a>
</details>
###### *see*: [15.27](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27)
***    
    
### Question 2.2
`1.` *Compile-error*     
`2.` *Runtime-error*     
`3.` *The result is 2*     
    
[![][code]](LE2.java "code")
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
###### *see*: [15.27](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27)
***    
### 15.27.1. Lambda Parameters    
***    
    
### Question 3.3
`1.` *Compile-error*     
`2.` *Runtime-error*     
`3.` *The result is 1*     
    
[![][code]](LE10.java "code")
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
###### *see*: [15.27.1](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.1)
***    
    
### Question 4.4
`1.` *Compile-error*     
`2.` *Runtime-error*     
`3.` *Successfully*     
    
[![][code]](LE11.java "code")
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
###### *see*: [15.27.1](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.1)
***    
    
### Question 5.5
`1.` *Compile-error*     
`2.` *Runtime-error*     
`3.` *Successfully*     
    
[![][code]](LE12.java "code")
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
###### *see*: [15.27.1](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.1), [15.12.2](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.12.2)
***    
### 15.27.2. Lambda Body    
***    
    
### Question 6.6
`1.` *Compile-error*     
`2.` *Runtime-error*     
`3.` *Output: <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;100<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;100*     
`4.` *Output: <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;100<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;200*     
    
[![][code]](LE13.java "code")
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
###### *see*: [15.27.2](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.2)
***    
    
### Question 7.7
`1.` *Compile-error*     
`2.` *Runtime-error*     
`3.` *Output: done*     
    
[![][code]](LE14.java "code")
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
###### *see*: [15.27.2](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.2)
***    
    
### Question 8.8
`1.` *Compile-error*     
`2.` *Runtime-error*     
`3.` *Output: 30*     
    
[![][code]](LE15.java "code")
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
###### *see*: [15.27.2](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.2)
***    
    
### Question 9.9
`1.` *Compile-error*     
`2.` *Runtime-error*     
`3.` *Output: 10*     
    
[![][code]](LE16.java "code")
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
###### *see*: [15.27.2](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.2)
***    
### 15.27.3. Type of a Lambda Expression    
***    
    
### Question 10.10
`1.` *Compile-error*     
`2.` *Runtime-error*     
`3.` *Output: 5*     
    
[![][code]](LE17.java "code")
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
###### *see*: [15.27.3](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.3)
***    
    
### Question 11.11
`1.` *Compile-error*     
`2.` *Runtime-error*     
`3.` *Output: 5*     
    
[![][code]](LE18.java "code")
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
###### *see*: [15.27.3](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.3)
***    

[![][back]](../README.md#lmb)

[key]: ../../images/key.png
[help]: ../../images/question-24.png
[code]: ../../images/source-code-24.png
[back]: ../../images/back-24.png
[play]: ../../images/play-24.png
[yes]: ../../images/yes-2-20.png