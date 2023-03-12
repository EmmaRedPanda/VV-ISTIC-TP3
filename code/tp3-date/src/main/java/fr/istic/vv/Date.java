package fr.istic.vv;

class Date implements Comparable<Date> {

    public int day;
    public int month;
    public int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public boolean isValidDate(int day, int month, int year) {
        if (month < 1 || month > 12) {
            return false;
        }
        if (day < 1 || day > daysInMonth(year, month)) {
            return false;
        }
        return true;
    }

    public boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return true;
        }
    }

    public Date nextDate() {
        int newDay = day + 1;
        int newMonth = month;
        int newYear = year;
        if (newDay > daysInMonth(year, month)) {
            newDay = 1;
            newMonth++;
            if (newMonth > 12) {
                newMonth = 1;
                newYear++;
            }
        }
        return new Date(newDay, newMonth, newYear);
    }

    public Date previousDate() {
        int newDay = day - 1;
        int newMonth = month;
        int newYear = year;
        if (newDay < 1) {
            newMonth--;
            if (newMonth < 1) {
                newYear--;
                newMonth = 12;
            }
            newDay = daysInMonth(newYear, newMonth);
        }
        return new Date(newDay, newMonth, newYear);
    }

    private int daysInMonth(int year, int month) {
        int[] days = {31, 28 + (isLeapYear(year) ? 1 : 0), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return days[month - 1];
    }

    @Override
    public int compareTo(Date other) {
        if (other == null) {
            throw new NullPointerException("Cannot compare to null");
        }
        if (year != other.year) {
            return year - other.year;
        } else if (month != other.month) {
            return month - other.month;
        } else {
            return day - other.day;
        }
    }

}