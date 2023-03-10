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

2) String with balanced grouping symbols
    - Characteristics: This input has an equal number of opening and closing grouping symbols, and they are arranged in a balanced way
    - Partition block: Balanced grouping symbols input

3) String with unbalanced grouping symbols
    - Characteristics: This input has an unequal number of opening and closing grouping symbols or they are arranged in an unbalanced way
    - Partition block: Unbalanced grouping symbols input

4) String with nested grouping symbols
    - Characteristics: This input has grouping symbols that are nested inside other grouping symbols
    - Partition block: Nested grouping symbols input

5) String with only opening or closing grouping symbols
    - Characteristics: This input has only opening or closing grouping symbols without any corresponding closing or opening symbols respectively
    - Partition block: Only opening or closing grouping symbols input

#### Part 2
