package ladjzero.hipda.core.parsers;

import ladjzero.hipda.core.api.Response;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by chenzhuo on 8/29/17.
 */
public class ExistedAttachParser extends Parser<String[]>{
    @Override
    public Response<String[]> parse(String html) {
        Response<String[]> res = new Response<>();
        Tuple<Document, Response.Meta> tuple = getDoc(html);
        Document doc = tuple.x;
        Response.Meta meta = tuple.y;
        res.setMeta(meta);

        Elements tds = doc.select("td[id^=image_td_]");
        ArrayList<String> attachIds = new ArrayList<>();

        for (Element td : tds) {
            String id = td.id();
            id = id.substring("image_td_".length());

            try {
                attachIds.add(id);
            } catch (Exception e) {

            }
        }

        res.setMeta(meta);
        res.setData(attachIds.toArray(new String[0]));

        return res;
    }

    @Override
    boolean test(List<String> paths, Map<String, String> query) {
        String action = query.get("action");
        String topicsubmit = query.get("topicsubmit");

        return paths.contains("post.php") && "newthread".equals(action) && !"yes".equals(topicsubmit);
    }
}
