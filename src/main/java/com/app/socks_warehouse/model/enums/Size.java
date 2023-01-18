package com.app.socks_warehouse.model.enums;

public enum Size {
    L("34"),
    S("36"),
    M("38"),
    XL("42"),
    XXL("45");
    private final String size;

    Size(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }

}
