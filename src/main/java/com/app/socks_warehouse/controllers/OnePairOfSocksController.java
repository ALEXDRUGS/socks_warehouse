package com.app.socks_warehouse.controllers;

import com.app.socks_warehouse.model.OnePairOfSocks;
import com.app.socks_warehouse.model.enums.Color;
import com.app.socks_warehouse.model.enums.Size;
import com.app.socks_warehouse.services.OnePairOfSocksService;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/socks")
public class OnePairOfSocksController {
    private final OnePairOfSocksService onePairOfSocksService;

    public OnePairOfSocksController(OnePairOfSocksService onePairOfSocksService) {
        this.onePairOfSocksService = onePairOfSocksService;
    }

    @PostMapping
    public OnePairOfSocks registersTheArrivalOfGoodsAtTheWarehouse(@RequestBody @NotNull OnePairOfSocks onePairOfSocks) {
        return onePairOfSocksService.registersTheArrivalOfGoodsAtTheWarehouse(onePairOfSocks);
    }

    @GetMapping
    public Integer returnsTheTotalNumberOfSocksInStockThatMatchTheRequestCriteriaPassedInTheParameters(@RequestParam(required = false, name = "color") Color color,
                                                                                                       @RequestParam(required = false, name = "size") Size size,
                                                                                                       @RequestParam(required = false, name = "cottonMin") Integer cottonMin,
                                                                                                       @RequestParam(required = false, name = "cottonMax") Integer cottonMax) {
        return onePairOfSocksService.returnsTheTotalNumberOfSocksInStockThatMatchTheRequestCriteriaPassedInTheParameters(color, size, cottonMin, cottonMax);
    }

    @PutMapping
    public void registersTheReleaseOfSocksFromTheWarehouse(@RequestParam OnePairOfSocks onePairOfSocks) {
        onePairOfSocksService.registersTheReleaseOfSocksFromTheWarehouse(onePairOfSocks);
    }

    @DeleteMapping
    public void registersTheWrite_offOfDamagedSocks(@RequestParam OnePairOfSocks onePairOfSocks) {
        onePairOfSocksService.registersTheReleaseOfSocksFromTheWarehouse(onePairOfSocks);
    }
}
