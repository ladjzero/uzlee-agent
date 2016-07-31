package com.ladjzero.uzlee.agent;

import com.google.gson.Gson;
import com.ladjzero.uzlee.parser.PostsParser;
import com.ladjzero.uzlee.parser.ResponseData;
import com.ladjzero.uzlee.parser.ThreadsParser;
import com.ladjzero.uzlee.parser.UserParser;
import nginx.clojure.java.NginxJavaBodyFilter;

import java.io.*;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/**
 * Created by chenzhuo on 16-4-10.
 */
public abstract class NginxBodyFilter implements NginxJavaBodyFilter {
    @Override
    public Object[] doFilter(Map<String, Object> request, InputStream bodyChunk, boolean isLast) throws IOException {
        if (isLast) {
            return new Object[]{200, null, bodyChunk};
        } else {
            ResponseData res = parseData(new GZIPInputStream(bodyChunk));
            String json = new Gson().toJson(res);

            return new Object[]{null, null, new ByteArrayInputStream(Utils.toGzipBytes(json))};
        }
    }

    abstract ResponseData parseData(InputStream html);
}
