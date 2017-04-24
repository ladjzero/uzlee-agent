package com.ladjzero.uzlee.agent;

import com.google.gson.Gson;
import com.ladjzero.uzlee.parser.Parse;
import com.ladjzero.uzlee.parser.Response;
import nginx.clojure.java.NginxJavaBodyFilter;

import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;

/**
 * Created by chenzhuo on 16-4-10.
 */
public abstract class NginxBodyFilter implements NginxJavaBodyFilter, Parse {
    @Override
    public Object[] doFilter(Map<String, Object> request, InputStream bodyChunk, boolean isLast) throws IOException {
        if (isLast) {
            return new Object[]{200, null, bodyChunk};
        } else {
            InputStream is = new GZIPInputStream(bodyChunk);
            Scanner s = new Scanner(is, "GBK").useDelimiter("\\A");
            String html = s.hasNext() ? s.next() : "";
            Response res = parse(html);
            String json = new Gson().toJson(res);

            return new Object[]{null, null, new ByteArrayInputStream(Utils.toGzipBytes(json))};
        }
    }
}
