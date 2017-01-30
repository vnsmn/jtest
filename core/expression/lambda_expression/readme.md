[![][back]](../README.md#lmb)
# 15.27 Lambda Expressions     
### 15.27 Lambda Expressions    
***    
<a name="LE1.java"></a>    
### Question 1.1
#### *Choose the correct answer?*
> `1.` *Compile-error*     
> `2.` *Runtime-error*     
> `3.` *Output: 234*     
    
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
![][yes] *Output: 234*<br>A lambda expression occurs in an assignment context (§5.2), an invocation context (§5.3), or a casting context (§5.5).<br><a href="LE1.java" target="_blank" title="code">![][code]</a>
</details>
<details markdown="1">
<summary><strong markdown="1" title="compile result">![][result]</strong></summary>
<pre>

234</pre></details>
###### *see*: [15.27](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27), [1](https://rawgit.com/vnsmn/jtest/master/core/resources/docs/core/jls-15.html#le1)
***    
<a name="LE2.java"></a>    
### Question 2.2
`1.` *Compile-error*     
`2.` *Runtime-error*     
`3.` *Output: 2*     
    
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
<details markdown="1">
<summary><strong markdown="1" title="compile result">![][result]</strong></summary>
<pre>
LE2.java:26: error: not a statement
        (i1) -&gt; i1 + i;
        ^
1 error
</pre></details>
###### *see*: [15.27](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27)
***    
<a name="LE3.java"></a>    
### Question 3.3
`1.` *Compile-error*     
`2.` *Runtime-error*     
`3.` *Output: 1*     
    
[![][code]](LE3.java "code")
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
LE3.java:19: error: illegal start of expression
        foo((FI&lt;Integer, Integer&gt;) &lt; Integer, Integer &gt; (w) -&gt; w);
                                                        ^
LE3.java:19: error: ';' expected
        foo((FI&lt;Integer, Integer&gt;) &lt; Integer, Integer &gt; (w) -&gt; w);
                                                         ^
LE3.java:19: error: illegal start of expression
        foo((FI&lt;Integer, Integer&gt;) &lt; Integer, Integer &gt; (w) -&gt; w);
                                                          ^
LE3.java:19: error: ';' expected
        foo((FI&lt;Integer, Integer&gt;) &lt; Integer, Integer &gt; (w) -&gt; w);
                                                           ^
LE3.java:19: error: not a statement
        foo((FI&lt;Integer, Integer&gt;) &lt; Integer, Integer &gt; (w) -&gt; w);
                                                               ^
LE3.java:19: error: ';' expected
        foo((FI&lt;Integer, Integer&gt;) &lt; Integer, Integer &gt; (w) -&gt; w);
                                                                ^
6 errors
</pre></details>
###### *see*: [15.27](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27)
***    
<a name="LE4.java"></a>    
### Question 4.4
`1.` *Compile-error*     
`2.` *Runtime-error*     
`3.` *Output: 1*     
    
[![][code]](LE4.java "code")
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
<summary><strong markdown="1" title="1">![][key]</strong></summary>
![][yes] *Compile-error*<br>Compile-error in 2.     
There is a precedent for ambiguity resolution involving casts, which essentially prohibits the use of - and + following a non-primitive cast (§15.15),     
but to extend that approach to generic lambdas would involve invasive changes to the grammar.<br><a href="LE4.java" target="_blank" title="code">![][code]</a>
</details>
<details markdown="1">
<summary><strong markdown="1" title="compile result">![][result]</strong></summary>
<pre>
LE4.java:22: error: cannot find symbol
        Integer i2 = (Integer) +d; //2
                      ^
  symbol:   variable Integer
  location: class LE4
LE4.java:22: error: illegal start of type
        Integer i2 = (Integer) +d; //2
                     ^
2 errors
</pre></details>
###### *see*: [15.27](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27)
***    
<a name="LE5.java"></a>    
### Question 5.5
`1.` *Compile-error*     
`2.` *Runtime-error*     
`3.` *Output: 2.0*     
    
[![][code]](LE5.java "code")
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
LE5.java:19: error: &lt;identifier&gt; expected
        FI f = (x, Double y) -&gt; x + y;
                 ^
1 error
</pre></details>
###### *see*: [15.27](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27)
***    
### 15.27.1. Lambda Parameters    
***    
<a name="LE10.java"></a>    
### Question 6.6
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
<details markdown="1">
<summary><strong markdown="1" title="compile result">![][result]</strong></summary>
<pre>
LE10.java:18: error: '_' used as an identifier
        FI f = (_) -&gt; _;
                ^
  (use of '_' as an identifier is forbidden for lambda parameters)
LE10.java:18: warning: '_' used as an identifier
        FI f = (_) -&gt; _;
                      ^
  (use of '_' as an identifier might not be supported in releases after Java SE 8)
1 error
1 warning
</pre></details>
###### *see*: [15.27.1](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.1)
***    
<a name="LE11.java"></a>    
### Question 7.7
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
<details markdown="1">
<summary><strong markdown="1" title="compile result">![][result]</strong></summary>
<pre>
LE11.java:23: error: unreported exception Exception; must be caught or declared to be thrown
        FI1 f1 = (x) -&gt; x.m1();
                            ^
1 error
</pre></details>
###### *see*: [15.27.1](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.1)
***    
<a name="LE12.java"></a>    
### Question 8.8
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
<details markdown="1">
<summary><strong markdown="1" title="compile result">![][result]</strong></summary>
<pre>
LE12.java:31: error: reference to m2 is ambiguous
        m2((x) -&gt; x.m1());
        ^
  both method m2(FI1) in LE12 and method m2(FI2) in LE12 match
1 error
</pre></details>
###### *see*: [15.27.1](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.1), [15.12.2](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.12.2)
***    
<a name="LE19.java"></a>    
### Question 9.9
`1.` *Compile-error in 1*     
`2.` *Compile-error in 2*     
`3.` *Compile-error in 3*     
`4.` *Runtime-error*     
`5.` *Output: 000*     
    
[![][code]](LE19.java "code")
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
LE19.java:27: error: legacy array notation not allowed on variable-arity parameter
        FI1 f2 = (Integer... x1[]) -&gt; x1.length; //2
                               ^
1 error
</pre></details>
###### *see*: [15.27](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.1)
***    
<a name="LE6.java"></a>    
### Question 10.10
`1.` *Compile-error*     
`2.` *Runtime-error*     
`3.` *Output: 2.0*     
    
[![][code]](LE6.java "code")
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
LE6.java:18: error: &lt;identifier&gt; expected
        FI f = (x, final y) -&gt; x + y;
                 ^
LE6.java:18: error: &lt;identifier&gt; expected
        FI f = (x, final y) -&gt; x + y;
                          ^
2 errors
</pre></details>
###### *see*: [15.27](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.1)
***    
<a name="LE7.java"></a>    
### Question 11.11
`1.` *Compile-error*     
`2.` *Runtime-error*     
`3.` *Output: 0*     
    
[![][code]](LE7.java "code")
```java
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

```
<details markdown="1">
<summary><strong markdown="1" title="3">![][key]</strong></summary>
![][yes] *Output: 0*<br> In a lambda body, a variable arity parameter is treated just like an array-typed parameter.<br><a href="LE7.java" target="_blank" title="code">![][code]</a>
</details>
<details markdown="1">
<summary><strong markdown="1" title="compile result">![][result]</strong></summary>
<pre>
LE7.java:18: error: ')' expected
        FI f = (Integer[] x, Integer... y, Integer... z) -&gt; x.length + y.length;
                                         ^
LE7.java:18: error: ';' expected
        FI f = (Integer[] x, Integer... y, Integer... z) -&gt; x.length + y.length;
                                                  ^
LE7.java:18: error: not a statement
        FI f = (Integer[] x, Integer... y, Integer... z) -&gt; x.length + y.length;
                                                      ^
LE7.java:18: error: ';' expected
        FI f = (Integer[] x, Integer... y, Integer... z) -&gt; x.length + y.length;
                                                       ^
LE7.java:18: error: not a statement
        FI f = (Integer[] x, Integer... y, Integer... z) -&gt; x.length + y.length;
                                                                     ^
5 errors
</pre></details>
###### *see*: [15.27](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.1)
***    
<a name="LE8.java"></a>    
### Question 12.12
`1.` *Compile-error*     
`2.` *Runtime-error*     
`3.` *Output: 1*     
    
[![][code]](LE8.java "code")
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
LE8.java:23: error: ')' expected
        FI f = (Integer this, Integer i) -&gt; i;
                       ^
LE8.java:23: error: illegal start of expression
        FI f = (Integer this, Integer i) -&gt; i;
                            ^
LE8.java:23: error: ';' expected
        FI f = (Integer this, Integer i) -&gt; i;
                                     ^
LE8.java:23: error: not a statement
        FI f = (Integer this, Integer i) -&gt; i;
                                      ^
LE8.java:23: error: ';' expected
        FI f = (Integer this, Integer i) -&gt; i;
                                       ^
LE8.java:23: error: not a statement
        FI f = (Integer this, Integer i) -&gt; i;
                                            ^
6 errors
</pre></details>
###### *see*: [15.27](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.1)
***    
<a name="LE9.java"></a>    
### Question 13.13
`1.` *Compile-error*     
`2.` *Runtime-error*     
`3.` *Output: 2*     
    
[![][code]](LE9.java "code")
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
LE9.java:19: error: variable x is already defined in method main(String[])
        FI f = (x, x) -&gt; x;
                   ^
1 error
</pre></details>
###### *see*: [15.27](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.1)
***    
### 15.27.2. Lambda Body    
***    
<a name="LE13.java"></a>    
### Question 14.14
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
<details markdown="1">
<summary><strong markdown="1" title="compile result">![][result]</strong></summary>
<pre>

100
200
</pre></details>
###### *see*: [15.27.2](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.2)
***    
<a name="LE14.java"></a>    
### Question 15.15
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
<details markdown="1">
<summary><strong markdown="1" title="compile result">![][result]</strong></summary>
<pre>
LE14.java:20: error: lambda body is neither value nor void compatible
        m1((i) -&gt; { if (100 == i) return &quot;done&quot;; System.out.println(&quot;done&quot;); });
           ^
LE14.java:20: error: method m1 in class LE14 cannot be applied to given types;
        m1((i) -&gt; { if (100 == i) return &quot;done&quot;; System.out.println(&quot;done&quot;); });
        ^
  required: FI
  found: (i)-&gt;{ if [...]&quot;); }
  reason: argument mismatch; bad return type in lambda expression
      missing return value
2 errors
</pre></details>
###### *see*: [15.27.2](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.2)
***    
<a name="LE15.java"></a>    
### Question 16.16
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
<details markdown="1">
<summary><strong markdown="1" title="compile result">![][result]</strong></summary>
<pre>
LE15.java:23: error: local variables referenced from a lambda expression must be final or effectively final
        y = m1((x) -&gt; x + y + z);
                          ^
1 error
</pre></details>
###### *see*: [15.27.2](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.2)
***    
<a name="LE16.java"></a>    
### Question 17.17
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
<details markdown="1">
<summary><strong markdown="1" title="compile result">![][result]</strong></summary>
<pre>
LE16.java:21: error: variable y might not have been initialized
        int z = m1((x) -&gt; x + y);
                              ^
1 error
</pre></details>
###### *see*: [15.27.2](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.2)
***    
### 15.27.3. Type of a Lambda Expression    
***    
<a name="LE17.java"></a>    
### Question 18.18
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
<details markdown="1">
<summary><strong markdown="1" title="compile result">![][result]</strong></summary>
<pre>
LE17.java:24: error: incompatible types: List&lt;Object&gt; cannot be converted to List&lt;Integer&gt;
            List&lt;Integer&gt; list = x; //true is List&lt;Object&gt; list = x;
                                 ^
1 error
</pre></details>
###### *see*: [15.27.3](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.3)
***    
<a name="LE18.java"></a>    
### Question 19.19
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
<details markdown="1">
<summary><strong markdown="1" title="compile result">![][result]</strong></summary>
<pre>
LE18.java:33: warning: [unchecked] unchecked method invocation: method exec in interface FI is applied to given types
        f.exec((List) l);
              ^
  required: List&lt;T&gt;
  found: List
  where T is a type-variable:
    T extends Object declared in interface FI
LE18.java:33: warning: [unchecked] unchecked conversion
        f.exec((List) l);
               ^
  required: List&lt;T&gt;
  found:    List
  where T is a type-variable:
    T extends Object declared in interface FI
2 warnings

5
</pre></details>
###### *see*: [15.27.3](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.3)
***    
<a name="LE20.java"></a>    
### Question 20.20
`1.` *Compile-error*     
`2.` *Runtime-error*     
`3.` *Output: 12*     
`4.` *Output: 21*     
    
[![][code]](LE20.java "code")
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

21</pre></details>
###### *see*: [15.27.3](http://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27.3), [1](https://rawgit.com/vnsmn/jtest/master/core/resources/docs/Chapter 15. Expressions.html#le1)
***    

[![][back]](../README.md#lmb)

[key]: ../../resources/images/key.png
[help]: ../../resources/images/question-24.png
[code]: ../../resources/images/source-code-24.png
[back]: ../../resources/images/back-24.png
[play]: ../../resources/images/play-24.png
[result]: ../../resources/images/settings-16-1.png
[yes]: ../../resources/images/yes-2-20.png