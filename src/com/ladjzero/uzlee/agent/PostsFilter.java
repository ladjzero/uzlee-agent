package com.ladjzero.uzlee.agent;

import com.ladjzero.uzlee.parser.PostsParser;
import com.ladjzero.uzlee.parser.ResponseData;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by chenzhuo on 16/7/31.
 */
public class PostsFilter extends NginxBodyFilter {
    @Override
    ResponseData parseData(InputStream html) {
        PostsParser.PostsData res = new PostsParser.PostsData();
        try {
            PostsParser.parsePosts(html, res);
        } catch (IOException e) {
            e.printStackTrace();
            res.success = false;
            res.errMsg = e.toString();
        }
        return res;
    }
}
