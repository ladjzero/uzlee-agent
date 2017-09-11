package ladjzero.hipda.nginx;

import ladjzero.hipda.core.api.Response;
import ladjzero.hipda.core.parsers.*;
import nginx.clojure.java.NginxJavaBodyFilter;

import java.io.*;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by chenzhuo on 16-4-10.
 */
public class NginxBodyFilter implements NginxJavaBodyFilter {
    static Parser[] parsers = new Parser[]{
            new EditablePostParser(),
            new ExistedAttachParser(),
            new FavoritesParser(),
            new LoggingParser(),
            new MarkedThreadsParser(),
            new MentionsParser(),
            new NullParser(),
            new OwnPostsParser(),
            new OwnThreadsParser(),
            new PostEditingParser(),
            new PostsParser(),
            new RawMessagesParser(),
            new ThreadsParser(),
            new UserParser(),
    };


    @Override
    public Object[] doFilter(Map<String, Object> request, InputStream bodyChunk, boolean isLast) throws IOException {
        if (isLast) {
            return new Object[]{200, null, bodyChunk};
        } else {
//            InputStream is = new GZIPInputStream(bodyChunk);
            Scanner s = new Scanner(bodyChunk, "GBK").useDelimiter("\\A");
            String html = s.hasNext() ? s.next() : "";
            String uri = (String) request.get("uri");
            Response res = new Response();

            Parsable parser = null;

            for (Parser p : parsers) {
                if (p.test(uri)) {
                    parser = p;
                    break;
                }
            }

            if (parser != null) {
                res = parser.parse(html);
            }

            return new Object[]{null, null, res.toString()};
        }
    }
}
