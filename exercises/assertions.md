# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1. It's because (3 * .4) produces decimals numbers after the point like 1.2000000000x. We want use a method as .equals() to make the comparison or autorise an imprecision + or - lambda when we compare with ==.

2. `assertEquals` test the value but `assertSame` check too the reference of the object.
For example :
public class JUnitAssertion { 
    @Test
    public void test() {
        String s1 = new String("HELLO"); 
        String s2 = new String("HELLO");
        assertEquals (s1, s2); //true
        assertSame (s1, s2); //false
        assertSame ("HELLO", "HELLO"); //true
    }
}

3. 
