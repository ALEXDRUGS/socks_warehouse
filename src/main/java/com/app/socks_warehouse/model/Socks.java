package com.app.socks_warehouse.model;

import com.app.socks_warehouse.model.enums.Color;
import com.app.socks_warehouse.model.enums.Composition;
import com.app.socks_warehouse.model.enums.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Socks {
    private Color color;
    private Size size;
    private Composition composition;
    private Integer quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Socks socks = (Socks) o;
        return color == socks.color && size == socks.size && composition == socks.composition && quantity.equals(socks.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, size, composition, quantity);
    }
}
