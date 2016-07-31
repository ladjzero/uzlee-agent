package com.ladjzero.uzlee.agent;

import com.ladjzero.uzlee.parser.ResponseData;
import com.ladjzero.uzlee.parser.ThreadsParser;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by chenzhuo on 16/7/31.
 */
public class ThreadsFilter extends NginxBodyFilter {
    @Override
    ResponseData parseData(InputStream html) {
        ThreadsParser.ThreadsData res = new ThreadsParser.ThreadsData();
        try {
            ThreadsParser.parseThreads(html, res);
        } catch (IOException e) {
            res.success = false;
            res.errMsg = e.toString();
        }
        return null;
    }
}
