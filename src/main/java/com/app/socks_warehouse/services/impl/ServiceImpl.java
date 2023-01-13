package com.app.socks_warehouse.services.impl;

import com.app.socks_warehouse.model.Socks;
import com.app.socks_warehouse.model.enums.Color;
import com.app.socks_warehouse.services.Service;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
    private final Map<Socks, Integer> socksMap = new HashMap<>();
    private Integer quantity = 0;

    public ServiceImpl() {
    }

    @Override
    public Socks addSocks(Socks socks) {
        if (socks != null) {
            socksMap.put(socks, ++quantity);
            //saveToFile();
        }
        return socks;
    }

    @Override
    public Integer getQuantityByColorSocks(String color) {
        int q = 0;
        for (int i = 0; i < socksMap.size(); i++) {
            q += socksMap.get(Color.valueOf(color));
        }
        return q;
    }
}
