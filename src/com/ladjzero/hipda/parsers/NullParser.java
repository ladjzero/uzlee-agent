package com.ladjzero.hipda.parsers;

import com.ladjzero.hipda.api.Response;

/**
 * Created by chenzhuo on 8/29/17.
 */
public class NullParser extends Parser {
    @Override
    public Response<String> parse(String html) {
        Response<String> res = new Response<>();
        res.setData(html);
        return res;
    }
}
