package com.app.socks_warehouse.services;

import com.app.socks_warehouse.model.OnePairOfSocks;
import com.app.socks_warehouse.model.enums.Color;

public interface OnePairOfSocksService {

    OnePairOfSocks registersTheArrivalOfGoodsAtTheWarehouse(Color color, Integer size, Integer cottonPart,
                                                            Integer quantity);

    Integer returnsTheTotalNumberOfSocksInStockThatMatchTheRequestCriteriaPassedInTheParameters(Color color, Integer size,
                                                                                                Integer cottonMin, Integer cottonMax);

    void registersTheReleaseOfSocksFromTheWarehouse(Color color, Integer size, Integer cottonPart,
                                                    Integer quantity);
}
