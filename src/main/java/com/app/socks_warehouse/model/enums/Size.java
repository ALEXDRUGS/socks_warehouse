package com.app.socks_warehouse.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Size {
    L("34"),
    S("36"),
    M("38"),
    XL("42"),
    XXL("45");
    @JsonValue
    private final String size;

    Size(String size) {
        this.size = size;
    }

    public String getDataSize() {
        return size;
    }

}
