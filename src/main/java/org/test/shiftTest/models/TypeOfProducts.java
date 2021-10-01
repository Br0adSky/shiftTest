package org.test.shiftTest.models;

public enum TypeOfProducts {
    NOTEBOOK("Ноутбук"),
    MONITOR("Монитор"),
    DESKTOP("Настольный компьютер"),
    HARD_DRIVE("Жесткий диск");
    private final String s;

    TypeOfProducts(String s) {
        this.s = s;
    }

    public String getValue() {
        return s;
    }
}
