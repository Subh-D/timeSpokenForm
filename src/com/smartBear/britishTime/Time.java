package com.smartBear.britishTime;

public record Time (int Hour, int Minute) {

    public Time {
        if (Hour < 0 || Hour > 23) {
            throw new InvalidTimeException("Invalid hour :" +Hour+ "Hour must be between 0 and 23");
        }
        if (Minute < 0 || Minute > 59) {
            throw new InvalidTimeException("Invalid minutes :" +Minute+ "Minute must be between 0 and 59");
        }
    }
}
