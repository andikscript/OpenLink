package com.andikscript.igate.service.mobile;

import com.andikscript.igate.access.PackagerAccess;
import com.andikscript.igate.util.DecodeIso;
import com.andikscript.igate.util.PrintIso;
import com.andikscript.igate.value.Direction;
import com.andikscript.igate.value.Module;
import org.springframework.stereotype.Service;

@Service
public class MobileImpl implements MobileService {

    private final DecodeIso decodeIso;

    private final PrintIso printIso;

    public MobileImpl(DecodeIso decodeIso, PrintIso printIso) {
        this.decodeIso = decodeIso;
        this.printIso = printIso;
    }

    @Override
    public String transfer(String message) {
        printIso.printIsoMessage(decodeIso.parseIsoMessage(message, PackagerAccess.ib), Direction.io, Module.ib);
        return "OK";
    }
}
