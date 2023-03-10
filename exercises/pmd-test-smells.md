# Detecting test smells with PMD

In folder [`pmd-documentation`](../pmd-documentation) you will find the documentation of a selection of PMD rules designed to catch test smells.
Identify which of the test smells discussed in classes are implemented by these rules.

Use one of the rules to detect a test smell in one of the following projects:

- [Apache Commons Collections](https://github.com/apache/commons-collections)
- [Apache Commons CLI](https://github.com/apache/commons-cli)
- [Apache Commons Math](https://github.com/apache/commons-math)
- [Apache Commons Lang](https://github.com/apache/commons-lang)

Discuss the test smell you found with the help of PMD and propose here an improvement.
Include the improved test code in this file.

## Answer

### Part 1 : PMD Documentation

- DetachedTestCase.md : X
- JUnit4SuitesShouldUseSuiteAnnotation.md : X
- JUnit4TestShouldUseAfterAnnotation.md : X
- JUnit4TestShouldUseBeforeAnnotation.md : X
- JUnit4TestShouldUseTestAnnotation.md : X
- JUnitAssertionsShouldIncludeMessage.md : Assertion roulette
- JUnitSpelling.md : The Local Hero
- JUnitStaticSuite.md : X
- JUnitTestContainsTooManyAsserts.md : Piggyback, Eager test
- JUnitTestsShouldIncludeAssert.md : X
- JUnitUseExpected.md : X
- UnnecessaryBooleanAssertion.md : X
- UseAssertEqualsInsteadOfAssertTrue.md : Equality pollution
- UseAssertNullInsteadOfAssertTrue.md : X
- UseAssertSameInsteadOfAssertTrue.md : X
- UseAssertTrueInsteadOfAssertEquals.md : X


### Part 2 : Detect a test smell

TestSmell : JUnitAssertionsShouldIncludeMessage
In : commons-math/commons-math-legacy/src/test/java/org/apache/commons/math4/legacy/genetics/RandomKeyTest.java
Line : 60 to 64
Solution : add a description parameter in assertions

The test improved :
```
 @Test
    public void testDecode() {
        DummyRandomKey drk = new DummyRandomKey(new Double[] {0.4, 0.1, 0.5, 0.8, 0.2});
        List<String> decoded = drk.decode(Arrays.asList(new String[] {"a", "b", "c", "d", "e"}));

        //Assert.assertEquals("b", decoded.get(0)); //BAD
        //Assert.assertEquals("e", decoded.get(1)); //BAD
        //Assert.assertEquals("a", decoded.get(2)); //BAD
        //Assert.assertEquals("c", decoded.get(3)); //BAD
        //Assert.assertEquals("d", decoded.get(4)); //BAD
        
        Assert.assertEquals("Key b from the list equals to decoded.get(0)","b", decoded.get(0)); //GOOD
        Assert.assertEquals("Key e from the list equals to decoded.get(1)","e", decoded.get(1)); //GOOD
        Assert.assertEquals("Key a from the list equals to decoded.get(2)","a", decoded.get(2)); //GOOD
        Assert.assertEquals("Key c from the list equals to decoded.get(3)","c", decoded.get(3)); //GOOD
        Assert.assertEquals("Key d from the list equals to decoded.get(4)","d", decoded.get(4)); //GOOD
    }
```
