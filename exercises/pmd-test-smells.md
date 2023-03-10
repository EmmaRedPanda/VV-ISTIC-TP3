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

