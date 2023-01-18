package com.app.socks_warehouse.services;

import com.app.socks_warehouse.model.OnePairOfSocks;
import com.app.socks_warehouse.model.enums.Color;
import com.app.socks_warehouse.model.enums.Size;

public interface OnePairOfSocksService {

    OnePairOfSocks registersTheArrivalOfGoodsAtTheWarehouse(Color color, Size size, Integer cottonPart,
                                                            Integer quantity);

    Integer returnsTheTotalNumberOfSocksInStockThatMatchTheRequestCriteriaPassedInTheParameters(Color color, Size size, Integer cottonMin, Integer cottonMax);

    void registersTheReleaseOfSocksFromTheWarehouse(Color color, Size size, Integer cottonPart,
                                                    Integer quantity);
}
