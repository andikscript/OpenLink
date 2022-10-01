package com.andikscript.igate.controller;

import com.andikscript.igate.service.core.CoreService;
import com.andikscript.igate.service.global.GlobalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/global")
public class GlobalController {

    private final GlobalService globalService;

    public GlobalController(GlobalService globalService) {
        this.globalService = globalService;
    }

    @PostMapping(value = "/transfer/{value}")
    public ResponseEntity<?> postTransfer(@PathVariable(value = "value") String message) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(globalService.transfer(message));
    }
}
