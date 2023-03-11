# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1. It's because (3 * .4) produces decimals numbers after the point like 1.2000000000x. We want use a method as .equals() to make the comparison or autorise an imprecision + or - lambda when we compare with ==.

2. `assertEquals` test the content but `assertSame` check the reference of the object.
For example :
```
public class JUnitAssertion { 
    @Test
    public void test() {
        String s1 = new String("HELLO"); 
        String s2 = new String("HELLO");
        assertEquals (s1, s2); //true
        assertSame (s1, s2); //false
        assertSame (s1, s1); //true
        assertSame ("HELLO", "HELLO"); //true
    }
}
```

3. 3 use cases :
- In this example, we have a test method that is not yet implemented. We use fail() to indicate that the test should fail until the method is implemented.
```
@Test
public void testMethodNotYetImplemented() {
    // TODO: implement this method
    fail("Method not yet implemented");
}
```

- In this example, we are testing the findIndex() method of an ArrayUtils class to ensure that it returns -1 when the specified element is not found in the array. We use fail() to indicate that the test has failed if the method returns a value other than -1.
```
@Test
public void testFindIndexReturnsNegativeOneForMissingElement() {
    int[] array = {1, 2, 3, 4, 5};
    int index = ArrayUtils.findIndex(array, 6);
    if (index != -1) {
        fail("Expected -1 but found " + index);
    }
}
```

- In this example, we are testing the factorial() method of a MathUtils class to ensure that it returns the correct value for the maximum input value of an integer. We use fail() to indicate that the test has failed if the actual output is not equal to the expected output.
```
@Test
public void testFactorialReturnsCorrectValueForMaxInput() {
    int input = Integer.MAX_VALUE;
    int expectedOutput = 0;
    int actualOutput = MathUtils.factorial(input);
    if (actualOutput != expectedOutput) {
        fail("Expected " + expectedOutput + " but found " + actualOutput);
    }
}
```

4. It provides a clear, concise, accurate and flexible way to check for expected exceptions in the tests.
