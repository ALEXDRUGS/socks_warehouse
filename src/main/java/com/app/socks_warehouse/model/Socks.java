package com.app.socks_warehouse.model;

import com.app.socks_warehouse.model.enums.Color;
import com.app.socks_warehouse.model.enums.Composition;
import com.app.socks_warehouse.model.enums.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Socks {
    private Enum<Color> color;
    private Enum<Size> size;
    private Enum<Composition> composition;
    private boolean isThereInStock;
}
