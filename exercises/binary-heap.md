# Implementing and testing a binary heap

A [*binary heap*](https://en.wikipedia.org/wiki/Binary_heap) is a data structure that contains comparable objects and it is able to efficiently return the lowest element.
This data structure relies on a binary tree to keep the insertion and deletion operations efficient. It is the base of the [*Heapsort* algorithm](https://en.wikipedia.org/wiki/Heapsort).

Implement a `BinaryHeap` class with the following interface:

```java
class BinaryHeap<T> {

    public BinaryHeap(Comparator<T> comparator) { ... }

    public T pop() { ... }

    public T peek() { ... }

    public void push(T element) { ... }

    public int count() { ... }

}
```

A `BinaryHeap` instance is created using a `Comparator` object that represents the ordering criterion between the objects in the heap.
`pop` returns and removes the minimum object in the heap. If the heap is empty it throws a `NotSuchElementException`.
`peek` similar to `pop`, returns the minimum object but it does not remove it from the `BinaryHeap`.
`push` adds an element to the `BinaryHeap`.
`count` returns the number of elements in the `BinaryHeap`.

Design and implement a test suite for this `BinaryHeap` class.
Feel free to add any extra method you may need.

Use the following steps to design the test suite:

1. With the help of *Input Space Partitioning* design a set of initial test inputs for each method. Write below the characteristics and blocks you identified for each method. Specify which characteristics are common to more than one method.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators check if the test cases written to far satisfy *Base Choice Coverage*. If needed add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Use the project in [tp3-heap](../code/tp3-heap) to complete this exercise.
[balanced-strings.md](balanced-strings.md)
## Answer

### Part 1

1) push method:
   - Characteristics:
     - The element is smaller than all existing elements in the heap.
     - The element is somewhere in between the existing elements in the heap.
     - The element is larger than all existing elements in the heap.
     - The element is equal to another element.
   - Blocks:
     - Inserting the first element in the heap.
     - Inserting an element that is smaller than all existing elements.
     - Inserting an element that is larger than all existing elements.
     - Inserting an element that is equal to another element.

2) pop method:
   - Characteristics:
     - The heap is empty.
     - There are elements in the heap.
   - Blocks:
     - Checking an empty heap.
     - Removing an element from the heap.

3) peek method:
   - Characteristics:
     - The heap is empty.
     - There are elements in the heap.
   - Blocks:
     - Checking an empty heap.
     - Checking an element from the heap.

4) count method:
   - Characteristics:
     - The heap is empty.
     - There are elements in the heap.
   - Blocks:
     - Counting the number of elements in an empty heap.
     - Counting the number of elements in a heap with elements.

Same characteristics for pop, peek and count methods.


### Part 2

Test with IntelliJ tool to run with coverage.
Result : coverage at 100%.


### Part 3

The push method is the only with a predicate that uses more than two boolean operators in BinaryHeap class.

We verify :

| Test Case    | current>=1 | comparator.compare(heap.get(current), heap.get(current-1))<0 |
|--------------|------------|--------------------------------------------------------------|
| heap.push(3) | false      | n/a                                                          |
| heap.push(1) | true       | true                                                         |
| heap.push(4) | true       | false                                                        |
| heap.push(1) | true       | true                                                         |


The push method in the BinaryHeap class has a while loop with two conditions: current>=1 and comparator.compare(heap.get(current), heap.get(current-1)) < 0. To achieve Base Choice Coverage, we need to have at least one test case that satisfies each of the two conditions.

- heap.push(3) satisfies the condition current>=1 is false, so the second condition is not evaluated and doesn't matter for this test case.
- heap.push(1) satisfies both conditions. The first time through the while loop, current is 1 and heap.get(current) is 1, while heap.get(current-1) is 3. Therefore, the second condition is true, and the loop swaps the elements at positions 0 and 1. The second time through the loop, current is 0 and there is no more swapping needed. The test case satisfies Base Choice Coverage for the second condition.
- heap.push(4) satisfies the condition current>=1 is true, but the second condition is false. Therefore, the loop does not execute and the new element 4 is added to the heap without any swapping. This test case satisfies Base Choice Coverage for the second condition.
- heap.push(1) satisfies both conditions. The first time through the while loop, current is 3 and heap.get(current) is 1, while heap.get(current-1) is 4. Therefore, the second condition is true, and the loop swaps the elements at positions 2 and 3. The second time through the loop, current is 2 and heap.get(current) is 1, while heap.get(current-1) is 3. Therefore, the second condition is true again, and the loop swaps the elements at positions 1 and 2. The third time through the loop, current is 1 and heap.get(current) is 1, while heap.get(current-1) is 1. Therefore, the second condition is false, and the loop exits. This test case satisfies Base Choice Coverage for the second condition.

So, the test cases satisfy Base Choice Coverage for the push method in the BinaryHeap class.


### Part 4

Run with mutations :
- Generated 23 mutations Killed 22 (96%)
- Ran 31 tests (1.35 tests per mutation)

Details :
```
/================================================================================
- Mutators
  ================================================================================
> org.pitest.mutationtest.engine.gregor.mutators.ConditionalsBoundaryMutator
>> Generated 5 Killed 4 (80%)
> KILLED 4 SURVIVED 1 TIMED_OUT 0 NON_VIABLE 0
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0
> NO_COVERAGE 0
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.IncrementsMutator
>> Generated 2 Killed 2 (100%)
> KILLED 2 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0
> NO_COVERAGE 0
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.NullReturnValsMutator
>> Generated 2 Killed 2 (100%)
> KILLED 2 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0
> NO_COVERAGE 0
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.VoidMethodCallMutator
>> Generated 2 Killed 2 (100%)
> KILLED 2 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0
> NO_COVERAGE 0
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.MathMutator
>> Generated 6 Killed 6 (100%)
> KILLED 6 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0
> NO_COVERAGE 0
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.PrimitiveReturnsMutator
>> Generated 1 Killed 1 (100%)
> KILLED 1 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0
> NO_COVERAGE 0
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.NegateConditionalsMutator
>> Generated 5 Killed 5 (100%)
> KILLED 5 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0
> NO_COVERAGE 0
--------------------------------------------------------------------------------
================================================================================
- Timings
  ================================================================================
> scan classpath : < 1 second
> coverage and dependency analysis : < 1 second
> build mutation tests : < 1 second
> run mutation analysis : 1 seconds
--------------------------------------------------------------------------------
> Total  : 1 seconds
--------------------------------------------------------------------------------
================================================================================
```
