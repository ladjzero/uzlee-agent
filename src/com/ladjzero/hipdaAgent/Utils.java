package com.ladjzero.hipdaAgent;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 * Created by chenzhuo on 4/13/16.
 */
public class Utils {
    public static byte[] toGzipBytes(String src) {
        GZIPOutputStream zout = null;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();

        try {
            zout = new GZIPOutputStream(bout);
            zout.write(src.getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (zout != null) {
                try {
                    zout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try {
                bout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return bout.toByteArray();
    }
}
