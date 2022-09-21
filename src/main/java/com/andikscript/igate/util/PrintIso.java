package com.andikscript.igate.util;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.springframework.stereotype.Component;

@Component
public class PrintIso {

    public void printIsoMessage(ISOMsg isoMsg, String direction, String module) {
        try {
            System.out.printf("<isomsg direction=\"%s\" module=\"%s\"/>%n", direction, module);
            System.out.printf("  <field id=\"0\" value=\"%s\"/>%n", isoMsg.getMTI());
            for (int i = 1; i <= isoMsg.getMaxField(); i++) {
                if (isoMsg.hasField(i)) {
                    System.out.printf("  <field id=\"%s\" value=\"%s\"/>%n", i, isoMsg.getString(i));
                }
            }
            System.out.printf("</isomsg>%n");
        } catch (ISOException e) {
            System.out.println(e.getMessage());
        }
    }
}
