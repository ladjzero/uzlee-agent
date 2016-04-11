package com.ladjzero.uzlee.agent;

import com.alibaba.fastjson.JSON;
import com.ladjzero.uzlee.parser.ThreadsParser;
import nginx.clojure.java.NginxJavaBodyFilter;

import java.io.*;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/**
 * Created by chenzhuo on 16-4-10.
 */
public class NginxBodyFilter implements NginxJavaBodyFilter {
    @Override
    public Object[] doFilter(Map<String, Object> request, InputStream bodyChunk, boolean isLast) throws IOException {
        if (isLast) {
            return new Object[]{200, null, bodyChunk};
        } else {
            ThreadsParser.ThreadsData res = new ThreadsParser.ThreadsData();
            ThreadsParser.parseThreads(new GZIPInputStream(bodyChunk), res);
            String json = JSON.toJSONString(res);

            return new Object[]{null, null, new ByteArrayInputStream(Utils.toGzipBytes(json))};
        }
    }
}
