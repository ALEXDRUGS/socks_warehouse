package com.app.socks_warehouse.model;

import com.app.socks_warehouse.model.enums.Color;
import com.app.socks_warehouse.model.enums.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OnePairOfSocks {
    private Color color;
    private Size size;
    private Integer cottonPart;
    private Integer quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OnePairOfSocks that = (OnePairOfSocks) o;
        return color == that.color && size == that.size && Objects.equals(cottonPart, that.cottonPart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, size, cottonPart);
    }
}
