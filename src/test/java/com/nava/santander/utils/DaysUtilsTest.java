package com.nava.santander.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DaysUtilsTest {

    @Test
    void getDaysByHours() {
        assertEquals(HoursUtils.getHoursBySeconds(22585), 6);
    }
}