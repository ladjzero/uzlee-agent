package ladjzero.hipda.nginx;

import nginx.clojure.java.Constants;
import nginx.clojure.java.NginxJavaHeaderFilter;

import java.io.IOException;
import java.util.Map;

/**
 * Created by chenzhuo on 4/12/16.
 */
public class HeaderFilter implements NginxJavaHeaderFilter {
    @Override
    public Object[] doFilter(int status, Map<String, Object> request, Map<String, Object> responseHeaders) throws IOException {
        responseHeaders.remove("Content-Encoding");
        return Constants.PHASE_DONE;
    }
}
