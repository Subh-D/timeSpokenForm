package com.smartBear.britishTime;

public class InvalidTimeException extends RuntimeException{

    public InvalidTimeException(String message) {
        super(message);
    }
}
