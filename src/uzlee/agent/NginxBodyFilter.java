package uzlee.agent;

import nginx.clojure.java.NginxJavaBodyFilter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * Created by chenzhuo on 16-4-10.
 */
public class NginxBodyFilter implements NginxJavaBodyFilter {
    @Override
    public Object[] doFilter(Map<String, Object> request, InputStream bodyChunk, boolean isLast) throws IOException {
        if (isLast) {
            return new Object[]{200, null, bodyChunk};
        } else {
            return new Object[]{null, null, bodyChunk};
        }
    }
}
