# Test the Date class

Implement a class `Date` with the interface shown below:

```java
class Date implements Comparable<Date> {

    public Date(int day, int month, int year) { ... }

    public static boolean isValidDate(int day, int month, int year) { ... }

    public static boolean isLeapYear(int year) { ... }

    public Date nextDate() { ... }

    public Date previousDate { ... }

    public int compareTo(Date other) { ... }

}
```

The constructor throws an exception if the three given integers do not form a valid date.

`isValidDate` returns `true` if the three integers form a valid year, otherwise `false`.

`isLeapYear` says if the given integer is a leap year.

`nextDate` returns a new `Date` instance representing the date of the following day.

`previousDate` returns a new `Date` instance representing the date of the previous day.

`compareTo` follows the `Comparable` convention:

* `date.compareTo(other)` returns a positive integer if `date` is posterior to `other`
* `date.compareTo(other)` returns a negative integer if `date` is anterior to `other`
* `date.compareTo(other)` returns `0` if `date` and `other` represent the same date.
* the method throws a `NullPointerException` if `other` is `null` 

Design and implement a test suite for this `Date` class.
You may use the test cases discussed in classes as a starting point. 
Also, feel free to add any extra method you may need to the `Date` class.


Use the following steps to design the test suite:

1. With the help of *Input Space Partitioning* design a set of initial test inputs for each method. Write below the characteristics and blocks you identified for each method. Specify which characteristics are common to more than one method.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators check if the test cases written to far satisfy *Base Choice Coverage*. If needed add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Use the project in [tp3-date](../code/tp3-date) to complete this exercise.

## Answer

### Part 1

1) isValidDate():
   - Characteristics:
     - Day and month in a valid range
     - Day outside valid range for given month and year (less than 1 or greater than the maximum number of days for the given month and year)
     - Month outside valid range (less than 1 or greater than 12)
   - Blocks:
     - Valid date
     - Invalid day (e.g., -1, 0, 32 for January, 31 for February in a non-leap year)
     - Invalid month (e.g., -1, 0, 13)
2) isLeapYear():
   - Characteristics:
     - Year not divisible by 4 (not a leap year)
     - Year divisible by 4 but not by 100 (leap year)
     - Year divisible by 100 but not by 400 (not a leap year)
     - Year divisible by 400 (leap year)
   - Blocks:
     - Leap year (e.g., 2000, 2024)
     - Non-leap year (e.g., 1999, 2022)
3) nextDate():
   - Characteristics:
     - Current day is not the last day of the month (simple case)
     - Current day is the last day of a non-December month (needs to increment month)
     - Current day is the last day of December (needs to increment year and reset month to January)
   - Blocks:
     - Simple case (e.g., February 1st, 2023)
     - End of non-December month (e.g., April 30th, 2023)
     - End of December (e.g., December 31st, 2023)
4) previousDate():
   - Characteristics:
     - Current day is not the first day of the month (simple case)
     - Current day is the first day of a non-January month (needs to decrement month)
     - Current day is the first day of January (needs to decrement year and set month to December)
   - Blocks:
     - Simple case (e.g., February 2nd, 2023)
     - Beginning of non-January month (e.g., April 1st, 2023)
     - Beginning of January (e.g., January 1st, 2023)
5) compareTo():
   - Characteristics:
     - Days, months and years are same
     - Days are different
     - Months are different
     - Years are different
   - Blocks:
     - Dates are same
     - Days are different (e.g., January 1st, 2023 and January 2nd, 2023)
     - Months are different (e.g., January 1st, 2023 and February 1st, 2023)
     - Years are different (e.g., January 1st, 2023 and January 1st, 2024)


### Part 2

Test with IntelliJ tool to run with coverage.
Result : coverage at 95%.

More tests added (test of isValidDate with invalid input and test of compareTo with invalid input too).
Result : coverage at 100%.


### Part 3

To check if the test cases written for isValidDate satisfy Base Choice Coverage, we need to create a table of all the possible inputs and their expected outputs. Base Choice Coverage requires that each condition in the code be tested with both true and false outcomes at least once.

In the case of the isValidDate method, there are two conditions:

The month must be between 1 and 12 (inclusive)
The day must be between 1 and the maximum number of days for the given month and year.
For simplicity, let's assume that the year is always a valid value (i.e. between some minimum and maximum year).

The table below shows all the possible combinations of inputs and their expected outputs. The expected output is "true" if the input values are valid and "false" if they are invalid.

| Day   | Month | Expected Output |
|-------|-------|----------------|
| 1-31  | 1     | true           |
| 1-28  | 2     | true           |
| 1-29  | 2     | true           |
| 1-31  | 3     | true           |
| 1-30  | 4     | true           |
| 1-31  | 5     | true           |
| 1-30  | 6     | true           |
| 1-31  | 7     | true           |
| 1-31  | 8     | true           |
| 1-30  | 9     | true           |
| 1-31  | 10    | true           |
| 1-30  | 11    | true           |
| 1-31  | 12    | true           |
| 0     | any   | false          |
| 32+   | any   | false          |
| any   | 0     | false          |
| any   | 13+   | false          |

Looking at the test cases written for isValidDate, we can see that they cover all the valid inputs, but they do not cover all the invalid inputs.
Specifically, they do not cover the cases where the day is 0 or greater than 31, or where the month is 0. To achieve Base Choice Coverage, we add test cases that cover these invalid inputs.


### Part 4

Run with mutations :
- Generated 50 mutations Killed 47 (94%)
- 94 tests (1.88 tests per mutation)

Details :
```
/================================================================================
- Mutators
================================================================================
> org.pitest.mutationtest.engine.gregor.mutators.BooleanTrueReturnValsMutator
>> Generated 4 Killed 4 (100%)
> KILLED 4 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 0 
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.ConditionalsBoundaryMutator
>> Generated 8 Killed 6 (75%)
> KILLED 6 SURVIVED 2 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 0 
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.IncrementsMutator
>> Generated 4 Killed 4 (100%)
> KILLED 4 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 0 
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.NullReturnValsMutator
>> Generated 2 Killed 2 (100%)
> KILLED 2 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 0 
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.MathMutator
>> Generated 10 Killed 9 (90%)
> KILLED 9 SURVIVED 1 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 0 
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.BooleanFalseReturnValsMutator
>> Generated 3 Killed 3 (100%)
> KILLED 3 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 0 
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.NegateConditionalsMutator
>> Generated 15 Killed 15 (100%)
> KILLED 15 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 0 
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.PrimitiveReturnsMutator
>> Generated 4 Killed 4 (100%)
> KILLED 4 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0 
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
> Total  : 2 seconds
--------------------------------------------------------------------------------
================================================================================
```

No good ideas to improve the coverage.