package com.app.socks_warehouse.controllers;

import com.app.socks_warehouse.model.Socks;
import com.app.socks_warehouse.services.Service;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/socks")
public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<Socks> addSocks(@RequestBody @NotNull Socks socks) {
        ResponseEntity<Socks> result;
        if (StringUtils.isBlank(socks.getColor().name())) {
            result = ResponseEntity.badRequest().build();
        } else {
            result = ResponseEntity.ok(service.addSocks(socks));
        }
        return result;
    }

    @GetMapping("/color")
    public Integer getQuantity(@RequestBody Socks socks) {
        return service.getQuantityByColorAndCompositionSocks(socks);
    }

    @GetMapping("/all")
    public Integer getAllSocks() {
        return service.getAll();
    }

    @PutMapping("/put")
    public void issueSocks(@RequestParam Socks socks,
                           @RequestParam Integer quantity) {
        service.issuesSocks(socks, quantity);
    }

    @DeleteMapping("/delete")
    public void deleteSocks(@RequestParam Socks socks,
                            @RequestParam Integer quantity) {
        service.issuesSocks(socks, quantity);
    }
}
