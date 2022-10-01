package com.andikscript.igate.service.atm;

import com.andikscript.igate.access.PackagerAccess;
import com.andikscript.igate.util.DecodeIso;
import com.andikscript.igate.util.PrintIso;
import com.andikscript.igate.value.Direction;
import com.andikscript.igate.value.Module;
import org.springframework.stereotype.Service;

@Service
public class AtmImpl implements AtmService {

    private final DecodeIso decodeIso;

    private final PrintIso printIso;

    public AtmImpl(DecodeIso decodeIso, PrintIso printIso) {
        this.decodeIso = decodeIso;
        this.printIso = printIso;
    }

    @Override
    public String transfer(String message) {
        String me = "08008220000000000800040000000000002009301535040797570003000000000000161049CSM(MCL/RSI RCV/11111111111 ORG/00000000212 SRV/)";
        printIso.printIsoMessage(decodeIso.parseIsoMessage(me, PackagerAccess.atm), Direction.io, Module.atm);
        return "OK";
    }
}
