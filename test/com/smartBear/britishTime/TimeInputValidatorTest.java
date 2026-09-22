package com.smartBear.britishTime;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TimeInputValidatorTest {

    private final TimeInputValidator validator =
            new TimeInputValidator();

    @Test
    void shouldParseValidTime() {
        assertEquals(
                new Time(1, 5),
                validator.parse("01:05")
        );
    }

    @Test
    void shouldRejectSingleDigitHour() {
        assertThrows(
                InvalidTimeException.class,
                () -> validator.parse("1:05")
        );
    }

    @Test
    void shouldRejectSingleDigitMinute() {
        assertThrows(
                InvalidTimeException.class,
                () -> validator.parse("01:5")
        );
    }

    @Test
    void shouldRejectInvalidHour() {
        assertThrows(
                InvalidTimeException.class,
                () -> validator.parse("25:00")
        );
    }

    @Test
    void shouldRejectInvalidMinute() {
        assertThrows(
                InvalidTimeException.class,
                () -> validator.parse("10:60")
        );
    }

    @Test
    void shouldRejectMissingInput() {
        assertThrows(
                InvalidTimeException.class,
                () -> validator.parse("")
        );
    }
}
