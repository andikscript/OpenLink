package com.andikscript.igate.service.itm;

import com.andikscript.igate.access.PackagerAccess;
import com.andikscript.igate.util.DecodeIso;
import com.andikscript.igate.util.PrintIso;
import com.andikscript.igate.value.Direction;
import com.andikscript.igate.value.Module;
import org.springframework.stereotype.Service;

@Service
public class ItmImpl implements ItmService {

    private final DecodeIso decodeIso;

    private final PrintIso printIso;

    public ItmImpl(DecodeIso decodeIso, PrintIso printIso) {
        this.decodeIso = decodeIso;
        this.printIso = printIso;
    }

    @Override
    public String transfer(String message) {
        printIso.printIsoMessage(decodeIso.parseIsoMessage(message, PackagerAccess.itm), Direction.io, Module.itm);
        return "OK";
    }
}
