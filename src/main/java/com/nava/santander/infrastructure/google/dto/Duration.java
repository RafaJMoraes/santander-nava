
package com.nava.santander.infrastructure.google.dto;


import com.nava.santander.utils.HoursUtils;

public record Duration (String text,
                        Integer value) {

    public long getValue() {
        return HoursUtils.getHoursBySeconds(value);
    }
}
