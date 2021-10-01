package org.test.shiftTest.models;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Dimensions {
    INCHES_13(13),
    INCHES_14(14),
    INCHES_15(15),
    INCHES_17(17);

    private final int value;

    Dimensions(int i) {
        this.value = i;
    }

    public static Dimensions getByValue(Integer value) {
        for (Dimensions d : values())
            if (d.value == value)
                return d;
        throw new IllegalArgumentException();
    }

    public Integer getValue() {
        return value;
    }
}
