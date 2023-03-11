# Balanced strings

A string containing grouping symbols `{}[]()` is said to be balanced if every open symbol `{[(` has a matching closed symbol `]}` and the substrings before, after and between each pair of symbols is also balanced. The empty string is considered as balanced.

For example: `{[][]}({})` is balanced, while `][`, `([)]`, `{`, `{(}{}` are not.

Implement the following method:

```java
public static boolean isBalanced(String str) {
    ...
}
```

`isBalanced` returns `true` if `str` is balanced according to the rules explained above. Otherwise, it returns `false`.

Use the coverage criteria studied in classes as follows:

1. Use input space partitioning to design an initial set of inputs. Explain below the characteristics and partition blocks you identified.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators check if the test cases written so far satisfy *Base Choice Coverage*. If needed add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Write below the actions you took on each step and the results you obtained.
Use the project in [tp3-balanced-strings](../code/tp3-balanced-strings) to complete this exercise.

## Answer

### Code

```
public static boolean isBalanced(String str) {
    Stack<Character> stack = new Stack<>();
    for (char c : str.toCharArray()) {
        if (c == '{' || c == '[' || c == '(') {
            stack.push(c);
        } else if (c == '}' || c == ']' || c == ')') {
            if (stack.isEmpty()) {
                return false;
            }
            char top = stack.pop();
            if ((c == '}' && top != '{') || (c == ']' && top != '[') || (c == ')' && top != '(')) {
                return false;
            }
        }
    }
    return stack.isEmpty();
}
```


### Tests


#### Part 1

Steps :
- Identified the characteristics of the input that may affect the behavior of the method. For the isBalanced method, the main characteristic is the presence and arrangement of grouping symbols.
- Created partition blocks for each characteristic or behavior. Each partition block groups together inputs that have similar characteristics or behaviors.
- Generated test cases for each partition block to ensure that the method behaves correctly for that block.

An initial set of inputs :
1) Empty string
    - Characteristics: This input has no grouping symbols
    - Partition block: Empty string input

2) String with only one opening grouping symbol
    - Characteristics: This input has only one opening symbol
    - Partition block: Unbalanced single opening symbols input

3) String with balanced nested grouping symbols
    - Characteristics: This input has grouping symbols that are nested inside other grouping symbols
    - Partition block: Nested grouping symbols input


#### Part 2

Steps :
- Run the existing test cases for the isBalanced method
- Collect code coverage information using a code coverage tool as IntelliJ tool or JaCoCo
- Identify the code statements that are not covered by the existing test cases
- Add new test cases to cover the remaining code statements
- Repeat previous steps until you achieve the desired level of code coverage

The initial set of test cases covers most of the code branches in the isBalanced method. There are a few additional test cases that can be added to increase the statement coverage and achieve 100% coverage :

- Test case for an input containing only one closing grouping symbol and no opening symbol:
```
isBalanced("}") => false
```
- Test case for a string with unbalanced nested grouping symbols:
```
isBalanced("{[}]") => false
```


#### Part 3

To verify this, we can create a table that lists each partition block along with the corresponding test case(s) that cover it. Then, we can check if each block has at least one test case that satisfies its base choice.

Partition Blocks:
| Block  | Description  | Test Case  |
|---|---|---|
| P1  | Balanced with empty string input  | isEmpty()  |
| P2  | Balanced with nested symbols  | nestedBalanced()  |
| P3  | Unbalanced with single opening symbol  | openingUnbalanced()  |
| P4  | Unbalanced with single closing symbol  | closingUnbalanced()  |
| P5  | Unbalanced with nested symbols  | nestedUnbalanced()  |
		
All partition blocks have at least one test case that satisfies their base choice, so the tests designed for isBalanced method satisfy Base Choice Coverage.

#### Part 4

Run with mutations : 
- Generated 17 mutations Killed 17 (100%)
- Ran 18 tests (1.06 tests per mutation)

Details :
```
/================================================================================
- Mutators
  ================================================================================
> org.pitest.mutationtest.engine.gregor.mutators.BooleanTrueReturnValsMutator
>> Generated 3 Killed 3 (100%)
> KILLED 3 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0
> NO_COVERAGE 0
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.BooleanFalseReturnValsMutator
>> Generated 1 Killed 1 (100%)
> KILLED 1 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0
> NO_COVERAGE 0
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.NegateConditionalsMutator
>> Generated 13 Killed 13 (100%)
> KILLED 13 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0
> NO_COVERAGE 0
--------------------------------------------------------------------------------
================================================================================
- Timings
  ================================================================================
> scan classpath : < 1 second
> coverage and dependency analysis : < 1 second
> build mutation tests : < 1 second
> run mutation analysis : < 1 second
--------------------------------------------------------------------------------
> Total  : 1 seconds
--------------------------------------------------------------------------------
================================================================================
```
