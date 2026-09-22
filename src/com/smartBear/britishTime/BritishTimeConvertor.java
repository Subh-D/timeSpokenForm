package com.smartBear.britishTime;

public class BritishTimeConvertor {

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
        return switch (hour) {
            case 0 -> "twelve";
            case 1 -> "one";
            case 2 -> "two";
            case 3 -> "three";
            case 4 -> "four";
            case 5 -> "five";
            case 6 -> "six";
            case 7 -> "seven";
            case 8 -> "eight";
            case 9 -> "nine";
            case 10 -> "ten";
            case 11 -> "eleven";
            case 12 -> "twelve";
            case 13 -> "one";
            case 14 -> "two";
            case 15 -> "three";
            case 16 -> "four";
            case 17 -> "five";
            case 18 -> "six";
            case 19 -> "seven";
            case 20 -> "eight";
            case 21 -> "nine";
            case 22 -> "ten";
            case 23 -> "eleven";
            default -> throw new IllegalArgumentException("Invalid hour: " + hour);
        };
    }

    private String minuteWord(int minute) {
        return switch (minute) {
            case 1 -> "one";
            case 2 -> "two";
            case 3 -> "three";
            case 4 -> "four";
            case 5 -> "five";
            case 6 -> "six";
            case 7 -> "seven";
            case 8 -> "eight";
            case 9 -> "nine";
            case 10 -> "ten";
            case 11 -> "eleven";
            case 12 -> "twelve";
            case 13 -> "thirteen";
            case 14 -> "fourteen";
            case 15 -> "quarter";
            case 16 -> "sixteen";
            case 17 -> "seventeen";
            case 18 -> "eighteen";
            case 19 -> "nineteen";
            case 20 -> "twenty";
            case 21 -> "twenty-one";
            case 22 -> "twenty-two";
            case 23 -> "twenty-three";
            case 24 -> "twenty-four";
            case 25 -> "twenty-five";
            case 26 -> "twenty-six";
            case 27 -> "twenty-seven";
            case 28 -> "twenty-eight";
            case 29 -> "twenty-nine";
            case 30 -> "thirty";
            case 31 -> "thirty-one";
            case 32 -> "thirty-two";
            case 33 -> "thirty-three";
            case 34 -> "thirty-four";
            case 35 -> "thirty-five";
            case 36 -> "thirty-six";
            case 37 -> "thirty-seven";
            case 38 -> "thirty-eight";
            case 39 -> "thirty-nine";
            case 40 -> "forty";
            case 41 -> "forty-one";
            case 42 -> "forty-two";
            case 43 -> "forty-three";
            case 44 -> "forty-four";
            case 45 -> "forty-five";
            case 46 -> "forty-six";
            case 47 -> "forty-seven";
            case 48 -> "forty-eight";
            case 49 -> "forty-nine";
            case 50 -> "fifty";
            case 51 -> "fifty-one";
            case 52 -> "fifty-two";
            case 53 -> "fifty-three";
            case 54 -> "fifty-four";
            case 55 -> "fifty-five";
            case 56 -> "fifty-six";
            case 57 -> "fifty-seven";
            case 58 -> "fifty-eight";
            case 59 -> "fifty-nine";
            default -> throw new IllegalArgumentException("Invalid minute: " + minute);
        };
    }
}
