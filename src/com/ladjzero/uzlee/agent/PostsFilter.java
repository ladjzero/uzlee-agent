package com.ladjzero.uzlee.agent;

import com.ladjzero.uzlee.parser.Response;

/**
 * Created by chenzhuo on 16/7/31.
 */
public class PostsFilter extends NginxBodyFilter {
    @Override
    public Response parse(String html) {
        return Parsers.getPostsParser().parse(html);
    }
}
