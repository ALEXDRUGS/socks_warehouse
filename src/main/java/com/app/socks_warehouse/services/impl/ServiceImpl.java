package com.app.socks_warehouse.services.impl;

import com.app.socks_warehouse.model.Socks;
import com.app.socks_warehouse.services.Service;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
    private final Map<Socks, Integer> socksMap = new HashMap<>();

    @Override
    public Socks addSocks(Socks socks) {
        socksMap.put(socks, socks.getQuantity());
        return socks;
    }

    @Override
    public Integer getQuantityByColorAndCompositionSocks(Socks socks) {
        int q = 0;
        for (Socks s : socksMap.keySet()) {
            if (socks.getSize() == null) {
                continue;
            }
            if (s.getColor().equals(socks.getColor()) && s.getComposition().equals(socks.getComposition())) {
                q += s.getQuantity();
            }
        }
        return q;
    }

    @Override
    public void issuesSocks(Socks socks, Integer quantity) {
        for (Socks s : socksMap.keySet()) {
            if (s.getColor().equals(socks.getColor())
                    && s.getComposition().equals(socks.getComposition())
                    && s.getQuantity() >= quantity) {
                Integer q = s.getQuantity() - quantity;
                socksMap.replace(socks, q);
            }
        }
    }

    @Override
    public Integer getAll() {
        Integer q = 0;
        for (Socks socks : socksMap.keySet()) {
            q += socks.getQuantity();
        }
        return q;
    }
}