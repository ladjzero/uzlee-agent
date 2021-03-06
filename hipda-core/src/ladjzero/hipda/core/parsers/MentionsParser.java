package ladjzero.hipda.core.parsers;

import ladjzero.hipda.core.entities.Post;
import ladjzero.hipda.core.entities.Posts;
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
public class MentionsParser extends Parser<Posts> {
    @Override
    public Response<Posts> parse(String html) {
        Response<Posts> res = new Response<>();
        Posts mentions = new Posts(new ArrayList<Post>());

        try {
            Tuple<Document, Response.Meta> tuple = getDoc(html);
            Document doc = tuple.x;
            res.setMeta(tuple.y);

            Elements eNotices = doc.select("ul.feed > li.s_clear > div");

            for (Element eNotice : eNotices) {
                String title;
                Elements eSummary = eNotice.select(">dl.summary");
                String body;
                String tid;
                String pid;
                String fid = "0";
                String findPostLink;
                if (eSummary.size() > 0) {
                    findPostLink = eNotice.select(">p>a").last().attr("href");
                    title = eNotice.select(">a").last().text();
                    body = eSummary.select("dt").last().text() + eSummary.select("dd").last().text();
                    String viewPostLink = eNotice.select(">p>a").first().attr("href");

                    fid = Utils.getUriQueryParameter(viewPostLink).get("tid");
                } else {
                    // thread watched on
                    Element lastA = eNotice.select(">a").last();
                    findPostLink = lastA.attr("href");
                    lastA.remove();
                    lastA = eNotice.select(">a").last();
                    title = lastA.text();
                    lastA.remove();

                    eNotice.select(">em").last().remove();
                    eNotice.select("dfn").remove();
                    body = eNotice.text();
                }

                Map<String, String> params = Utils.getUriQueryParameter(findPostLink);

                tid = params.get("ptid");
                pid = params.get("pid");
                if (tid == null) tid = "0";
                if (pid == null) pid = "0";

                Post post = new Post().setId(Integer.valueOf(pid))
                        .setTid(Integer.valueOf(tid))
                        .setFid(Integer.valueOf(fid))
                        .setTitle(title).setBody(body);
                mentions.getRecords().add(post);
            }

            int currPage = 1;
            Elements page = doc.select("div.pages > strong");

            if (page.size() > 0) {
                currPage = Integer.valueOf(page.first().text());
            }

            boolean hasNextPage = doc.select("div.pages > a[href$=&page=" + (currPage + 1) + "]").size() > 0;

            // TO-DO
            mentions.setHasNextPage(hasNextPage);
            mentions.setPage(currPage);
        } catch (Exception e) {
            e.printStackTrace();
        }

        res.setData(mentions);

        return res;
    }

    @Override
    boolean test(List<String> paths, Map<String, String> query) {
        return paths.contains("notice.php");
    }
}
