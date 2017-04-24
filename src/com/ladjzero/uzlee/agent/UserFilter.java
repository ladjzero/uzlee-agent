package com.ladjzero.uzlee.agent;

import com.ladjzero.uzlee.parser.Response;

/**
 * Created by chenzhuo on 16/7/31.
 */
public class UserFilter extends NginxBodyFilter {
    @Override
    public Response parse(String html) {
        return Parsers.getUserParser().parse(html);
    }
}
