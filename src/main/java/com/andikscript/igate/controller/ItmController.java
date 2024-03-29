package com.andikscript.igate.controller;

import com.andikscript.igate.service.itm.ItmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/itm")
public class ItmController {

    private final ItmService itmService;

    public ItmController(ItmService itmService) {
        this.itmService = itmService;
    }

    @PostMapping(value = "/transfer/{value}")
    public ResponseEntity<?> postTransfer(@PathVariable(value = "value") String message) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(itmService.transfer(message));
    }
}
