package com.andikscript.igate.controller;

import com.andikscript.igate.service.mobile.MobileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/mobile")
public class MobileController {

    private final MobileService mobileService;

    public MobileController(MobileService mobileService) {
        this.mobileService = mobileService;
    }

    @PostMapping(value = "/transfer/{value}")
    public ResponseEntity<?> postTransfer(@PathVariable(value = "value") String message) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mobileService.transfer(message));
    }
}