package ladjzero.hipda.core.parsers;

import ladjzero.hipda.core.api.Response;

import java.util.List;
import java.util.Map;

/**
 * Created by chenzhuo on 8/31/17.
 */
public class PostEditingParser extends Parser<String> {
    @Override
    public Response<String> parse(String html) {
        Response<String> res = new Response<>();

        if (html.contains("未定义操作，请返回。")) {
            res.setSuccess(false);
            res.setMessage("未定义操作");
        }

        return res;
    }

    @Override
    boolean test(List<String> paths, Map<String, String> query) {
        String editsubmit = query.get("editsubmit");
        String action = query.get("action");

        return paths.contains("post.php") && "yes".equals(editsubmit) && "edit".equals(action);
    }
}
