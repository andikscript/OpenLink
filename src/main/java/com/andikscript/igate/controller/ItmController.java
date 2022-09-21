package com.andikscript.igate.controller;

import com.andikscript.igate.access.PackagerAccess;
import com.andikscript.igate.util.DecodeIso;
import com.andikscript.igate.value.Direction;
import com.andikscript.igate.value.Module;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/itm")
public class ItmController {

    private final DecodeIso decodeIso;

    public ItmController(DecodeIso decodeIso) {
        this.decodeIso = decodeIso;
    }

    @PostMapping(value = "/transfer/{value}")
    public ResponseEntity<?> postTransfer(@PathVariable(value = "value") String message) {
        decodeIso.printIsoMessage(decodeIso.parseIsoMessage(message, PackagerAccess.itm), Direction.io, Module.itm);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("OK");
    }
}
