package com.smartBear.britishTime;

public class BritishTimeConverter {

    private static final String[] TENS = {
        "", "", "twenty", "thirty", "forty", "fifty"
    };

    private static final String[] ONES = {
        "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
        "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
        "sixteen", "seventeen", "eighteen", "nineteen"
    };


    public String convert(Time time){
        int hour = time.Hour();
        int minute = time.Minute();

        if (hour == 0 && minute == 0) {
            return "midnight";
        }

        if (hour == 12 && minute == 0) {
            return "noon";
        }

        if (minute == 0) {
            return hourWord(hour) + " o'clock";
        }

        if (minute == 15) {
            return "quarter past " + hourWord(hour);
        }

        if (minute >= 1 && minute <= 29) {
            return minuteWord(minute) + " past " + hourWord(hour);
        }

        if (minute == 30) {
            return "half past " + hourWord(hour);
        }

        if (minute >= 31 && minute <= 34) {
            return hourWord(hour) + " " + minuteWord(minute);
        }

        int minutesToNextHour = 60 - minute;
        int nextHour = (hour + 1) % 24;

        if (minute == 45) {
            return "quarter to " + hourWord(nextHour);
        }

        return minuteWord(minutesToNextHour) + " to " + hourWord(nextHour);
    }

    private String hourWord(int hour) {
        if(hour < 0 || hour > 23){
            throw new InvalidTimeException("Invalid hour: " + hour);
        }

        int twelveHour = hour % 12;
        if(twelveHour == 0) twelveHour = 12;
        return ONES[twelveHour];
    }

    private String minuteWord(int minute) {
        if(minute < 0 || minute > 59){
            throw new InvalidTimeException("Invalid minute: " + minute);
        }

        if(minute < 20){
            return ONES[minute];
        }
        int tens = minute/10;
        int ones = minute%10;

        if(ones == 0){
            return TENS[tens];
        } else {
            return TENS[tens] +"-"+ ONES[ones];
        }
    }
}
