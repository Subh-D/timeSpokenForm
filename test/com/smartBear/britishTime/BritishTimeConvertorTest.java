package com.smartBear.britishTime;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BritishTimeConverterTest {

    private final BritishTimeConverter converter =
            new BritishTimeConverter();

    @Test
    void shouldReturnMidnight() {
        assertEquals("midnight", converter.convert(new Time(0, 0)));
    }

    @Test
    void shouldReturnNoon() {
        assertEquals("noon", converter.convert(new Time(12, 0)));
    }

    @Test
    void shouldReturnOClock() {
        assertEquals(
                "one o'clock",
                converter.convert(new Time(1, 0))
        );
    }

    @Test
    void shouldReturnPast() {
        assertEquals(
                "twenty past five",
                converter.convert(new Time(5, 20))
        );
    }

    @Test
    void shouldReturnQuarterPast() {
        assertEquals(
                "quarter past four",
                converter.convert(new Time(4, 15))
        );
    }

    @Test
    void shouldReturnHalfPast() {
        assertEquals(
                "half past seven",
                converter.convert(new Time(7, 30))
        );
    }

    @Test
    void shouldReturnDirectMinutesBetween31And34() {
        assertEquals(
                "six thirty-two",
                converter.convert(new Time(6, 32))
        );
    }

    @Test
    void shouldReturnTo() {
        assertEquals(
                "twenty-five to eight",
                converter.convert(new Time(7, 35))
        );
    }

    @Test
    void shouldReturnQuarterTo() {
        assertEquals(
                "quarter to ten",
                converter.convert(new Time(9, 45))
        );
    }

    @Test
    void shouldHandleHourRollover() {
        assertEquals(
                "five to twelve",
                converter.convert(new Time(11, 55))
        );
    }

    @Test
    void shouldHandleAfternoonHours() {
        // 14:20 should be "twenty past two"
        assertEquals(
                "twenty past two",
                converter.convert(new Time(14, 20)));
    }

    @Test
    void shouldHandleRolloverToMidnight() {
        assertEquals(
                "five to twelve",
                converter.convert(new Time(23, 55)));
    }

    @Test
    void shouldHandleOneMinutePast() {
        assertEquals(
                "one past six",
                converter.convert(new Time(6, 1)));
    }

    @Test
    void shouldHandleOneMinuteTo() {
        assertEquals(
                "one to seven",
                converter.convert(new Time(6, 59)));
    }

    @Test
    void shouldThrowExceptionForInvalidHour() {
        org.junit.jupiter.api.Assertions.assertThrows(
                InvalidTimeException.class,
                () -> converter.convert(new Time(24, 0))
        );
    }

    @Test
    void shouldThrowExceptionForInvalidMinute() {
        org.junit.jupiter.api.Assertions.assertThrows(
                InvalidTimeException.class,
                () -> converter.convert(new Time(10, 60))
        );
    }
}
