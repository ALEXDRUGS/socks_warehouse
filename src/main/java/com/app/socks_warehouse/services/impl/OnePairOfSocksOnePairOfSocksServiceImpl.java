package com.app.socks_warehouse.services.impl;

import com.app.socks_warehouse.exceptions.InvalidSocksException;
import com.app.socks_warehouse.model.OnePairOfSocks;
import com.app.socks_warehouse.model.enums.Color;
import com.app.socks_warehouse.model.enums.Size;
import com.app.socks_warehouse.services.OnePairOfSocksService;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Service
public class OnePairOfSocksOnePairOfSocksServiceImpl implements OnePairOfSocksService {
    private final Map<OnePairOfSocks, Integer> socksMap = new HashMap<>();

    @Override
    public OnePairOfSocks registersTheArrivalOfGoodsAtTheWarehouse(OnePairOfSocks onePairOfSocks) {
        if (onePairOfSocks.getColor() == null || onePairOfSocks.getSize() == null) {
            throw new InvalidSocksException("All fields should be filled");
        }
        if (onePairOfSocks.getCottonPart() < 0 || onePairOfSocks.getCottonPart() > 100) {
            throw new InvalidSocksException("Cotton part should be between 0 and 100");
        }
        if (onePairOfSocks.getQuantity() <= 0) {
            throw new InvalidSocksException("Quantity should be more than 0");
        }
        if (socksMap.containsKey(onePairOfSocks)) {
            socksMap.put(onePairOfSocks, socksMap.get(onePairOfSocks) + onePairOfSocks.getQuantity());
        } else {
            socksMap.put(onePairOfSocks, onePairOfSocks.getQuantity());
        }
        return onePairOfSocks;
    }

    @Override
    public Integer returnsTheTotalNumberOfSocksInStockThatMatchTheRequestCriteriaPassedInTheParameters(Color color, Size size, Integer cottonMin, Integer cottonMax
    ) {
        int q = 0;
       for (Map.Entry<OnePairOfSocks, Integer> entry : socksMap.entrySet()){
           if (color != null && !entry.getKey().getColor().equals(color)) {
               continue;
           }
           if (size != null && !entry.getKey().getSize().equals(size)) {
               continue;
           }
           if (cottonMin != null && entry.getKey().getCottonPart() < cottonMin) {
               continue;
           }
           if (cottonMax != null && entry.getKey().getCottonPart() > cottonMax) {
               continue;
           }
           q += entry.getValue();
        }
        return q;
    }

    @Override
    public void registersTheReleaseOfSocksFromTheWarehouse(OnePairOfSocks onePairOfSocks) {
        if (onePairOfSocks.getColor() == null || onePairOfSocks.getSize() == null) {
            throw new InvalidSocksException("All fields should be filled");
        }
        if (onePairOfSocks.getCottonPart() < 0 || onePairOfSocks.getCottonPart() > 100) {
            throw new InvalidSocksException("Cotton part should be between 0 and 100");
        }
        if (onePairOfSocks.getQuantity() <= 0) {
            throw new InvalidSocksException("Quantity should be more than 0");
        }
        Integer q = socksMap.getOrDefault(onePairOfSocks, 0);
        if (q >= onePairOfSocks.getQuantity()) {
            socksMap.put(onePairOfSocks, q - onePairOfSocks.getQuantity());
        } else {
            throw new InvalidSocksException("There is no socks");
        }
    }
}