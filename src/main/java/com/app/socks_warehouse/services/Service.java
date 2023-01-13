package com.app.socks_warehouse.services;

import com.app.socks_warehouse.model.Socks;

public interface Service {
    Socks addSocks(Socks socks);

    Integer getQuantityByColorSocks(String color);
}
