package com.andikscript.igate.util;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class DecodeIso {

    public ISOMsg parseIsoMessage(String message, String access) {
        ISOMsg isoMsg = new ISOMsg();

        try {
            InputStream inputStream = getClass().getResourceAsStream(access);
            GenericPackager packager = new GenericPackager(inputStream);

            isoMsg.setPackager(packager);
            isoMsg.unpack(message.getBytes());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return isoMsg;
    }
}
