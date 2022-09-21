package com.andikscript.igate.controller;

import com.andikscript.igate.access.PackagerAccess;
import com.andikscript.igate.util.DecodeIso;
import com.andikscript.igate.value.Direction;
import com.andikscript.igate.value.Module;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/mobile")
public class MobileController {

    private final DecodeIso decodeIso;

    public MobileController(DecodeIso decodeIso) {
        this.decodeIso = decodeIso;
    }

    @GetMapping(value = "/transfer", produces = "application/json")
    public ResponseEntity<?> transfer() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Ini transfer");
    }

    @PostMapping(value = "/transfer/{value}")
    public ResponseEntity<?> postTransfer(@PathVariable(value = "value") String message) {
        decodeIso.printIsoMessage(decodeIso.parseIsoMessage(message, PackagerAccess.ib), Direction.io, Module.ib);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("OK");
    }
}