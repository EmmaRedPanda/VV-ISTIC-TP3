package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    // Tests for isValidDate

    @Test
    public void testIsValidDateValidInputs() {
        Date date = new Date(1, 1, 2022);
        assertTrue(date.isValidDate(date.day, date.month, date.year));
    }

    @Test
    public void testIsValidDateInvalidDay() {
        Date date = new Date(31, 2, 2022);
        assertFalse(date.isValidDate(date.day, date.month, date.year));
    }

    @Test
    public void testIsValidDateInvalidMonth() {
        Date date = new Date(1, 13, 2022);
        assertFalse(date.isValidDate(date.day, date.month, date.year));
    }

    // Tests for isLeapYear

    @Test
    public void testIsLeapYearTrue() {
        Date date = new Date(1, 1, 2000);
        assertTrue(date.isLeapYear(date.year));
    }

    @Test
    public void testIsLeapYearFalse() {
        Date date = new Date(1, 1, 1900);
        assertFalse(date.isLeapYear(date.year));
    }

    // Tests for nextDate

    @Test
    public void testNextDateSameMonth() {
        Date date = new Date(1, 1, 2022);
        Date nextDate = date.nextDate();
        assertEquals(2, nextDate.day);
        assertEquals(1, nextDate.month);
        assertEquals(2022, nextDate.year);
    }

    @Test
    public void testNextDateNextMonth() {
        Date date = new Date(31, 1, 2022);
        Date nextDate = date.nextDate();
        assertEquals(1, nextDate.day);
        assertEquals(2, nextDate.month);
        assertEquals(2022, nextDate.year);
    }

    @Test
    public void testNextDateEndOfYear() {
        Date date = new Date(31, 12, 2022);
        Date nextDate = date.nextDate();
        assertEquals(1, nextDate.day);
        assertEquals(1, nextDate.month);
        assertEquals(2023, nextDate.year);
    }

    // Tests for previousDate

    @Test
    public void testPreviousDateSameMonth() {
        Date date = new Date(2, 1, 2022);
        Date previousDate = date.previousDate();
        assertEquals(1, previousDate.day);
        assertEquals(1, previousDate.month);
        assertEquals(2022, previousDate.year);
    }

    @Test
    public void testPreviousDatePreviousMonth() {
        Date date = new Date(1, 2, 2022);
        Date previousDate = date.previousDate();
        assertEquals(31, previousDate.day);
        assertEquals(1, previousDate.month);
        assertEquals(2022, previousDate.year);
    }

    @Test
    public void testPreviousDateBeginningOfYear() {
        Date date = new Date(1, 1, 2022);
        Date previousDate = date.previousDate();
        assertEquals(31, previousDate.day);
        assertEquals(12, previousDate.month);
        assertEquals(2021, previousDate.year);
    }

    // Tests for compareTo

    @Test
    void testCompareTo() {
        Date date1 = new Date(1, 1, 2022);
        Date date2 = new Date(1, 1, 2022);
        Date date3 = new Date(2, 1, 2022);
        Date date4 = new Date(1, 2, 2022);
        Date date5 = new Date(1, 1, 2023);

        // Test same date
        assertEquals(0, date1.compareTo(date2));

        // Test same month, different day
        //assertTrue(date1.compareTo(date3) < 0);
        assertTrue(date3.compareTo(date1) > 0);

        // Test same year, different month
        assertTrue(date1.compareTo(date4) < 0);
        //assertTrue(date4.compareTo(date1) > 0);

        // Test different year
        //assertTrue(date1.compareTo(date5) < 0);
        assertTrue(date5.compareTo(date1) > 0);
    }

    // More tests (Part 2)

    @Test
    public void testIsValidDateInvalidInput() {
        Date date = new Date(29, 2, 2020);
        assertTrue(date.isValidDate(date.day, date.month, date.year));
    }

    @Test
    void testCompareToNullObject() {
        Date date1 = new Date(1, 1, 2022);
        assertThrows(NullPointerException.class, () -> date1.compareTo(null));
    }

    // More and more tests (Part 3)

    @Test
    public void testIsValidDateZeroDay() {
        Date date = new Date(0, 1, 2000);
        assertFalse(date.isValidDate(date.day, date.month, date.year));
    }

    @Test
    public void testIsValidDateInvalidDayV2() {
        Date date = new Date(32, 12, 2022);
        assertFalse(date.isValidDate(date.day, date.month, date.year));
    }

    @Test
    public void testIsValidDateZeroMonth() {
        Date date = new Date(1, 0, 2000);
        assertFalse(date.isValidDate(date.day, date.month, date.year));
    }

}