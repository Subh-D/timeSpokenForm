package com.smartBear.britishTime;

import java.util.regex.Pattern;

public class TimeInputValidator {

    public static final Pattern TIME_PATTERN = Pattern.compile("^(\\d{2}):(\\d{2})$");

    public Time parse(String input){

        if(input == null || input.isEmpty()){
            throw new InvalidTimeException("Input is required");
        }

        var matcher = TIME_PATTERN.matcher(input);

        if(!matcher.matches()){
            throw new InvalidTimeException("Invalid time format. Expected format is HH:MM");
        }

        int hour = Integer.parseInt(matcher.group(1));
        int minute = Integer.parseInt(matcher.group(2));

        return new Time(hour, minute);
    }
}
