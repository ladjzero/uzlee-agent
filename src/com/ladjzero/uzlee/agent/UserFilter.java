package com.ladjzero.uzlee.agent;

import com.ladjzero.uzlee.parser.ResponseData;
import com.ladjzero.uzlee.parser.UserParser;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by chenzhuo on 16/7/31.
 */
public class UserFilter extends NginxBodyFilter {
    @Override
    ResponseData parseData(InputStream html) {
        UserParser.UserData res = new UserParser.UserData();
        try {
            UserParser.parseUser(html, res);
        } catch (IOException e) {
            e.printStackTrace();
            res.success = false;
            res.errMsg = e.toString();
        }

        return res;
    }
}
