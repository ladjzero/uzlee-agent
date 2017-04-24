package com.ladjzero.uzlee.agent;

import com.ladjzero.uzlee.parser.PostsParser;
import com.ladjzero.uzlee.parser.ThreadsParser;
import com.ladjzero.uzlee.parser.UserParser;

/**
 * Created by chenzhuo on 4/24/17.
 */
public class Parsers {
    static private PostsParser postsParser;
    static private ThreadsParser threadsParser;
    static private UserParser userParser;

    static PostsParser getPostsParser() {
        if (postsParser == null) {
            postsParser = new PostsParser();
        }

        return postsParser;
    }

    static ThreadsParser getThreadsParser() {
        if (threadsParser == null) {
            threadsParser = new ThreadsParser();
        }

        return threadsParser;
    }

    static UserParser getUserParser() {
        if (userParser == null) {
            userParser = new UserParser();
        }

        return userParser;
    }
}
