package ladjzero.hipda.core.parsers;

import ladjzero.hipda.core.api.Response;

import java.util.List;
import java.util.Map;

/**
 * Created by chenzhuo on 8/31/17.
 */
public class LoggingParser extends Parser<Object> {
    @Override
    public Response<Object> parse(String html) {
        Response res = new Response();

        if (html.contains("欢迎您回来")) {
            return res;
        } else if (html.contains("密码错误次数过多，请 15 分钟后重新登录")) {
            res.setSuccess(false);
            res.setMessage("密码错误次数过多，请 15 分钟后重新登录");
        } else {
            res.setSuccess(false);
            res.setMessage("登录错误");
        }

        return res;
    }

    @Override
    boolean test(List<String> paths, Map<String, String> query) {
        String action = query.get("action");

        return paths.contains("logging.php") && "login".equals(action);
    }
}
