package com.ladjzero.uzlee.parser;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chenzhuo on 16-2-11.
 */
public class ThreadsParser extends Parser {

	private static final Pattern COLOR_REG = Pattern.compile("#(\\d|[A-F])+");

	public static class ThreadsData extends ResponseData {
		public ArrayList<Thread> threads = new ArrayList<>();
		public int page;
		public boolean hasNextPage;
	}

	public static void parseThreads(InputStream html, ThreadsData res) throws IOException {
		Document doc = getDoc(html, res);

		String selectStr = "tbody[id^=normalthread_],tbody[id^=stickthread_";

		Elements eThreads = doc.select("body#search").size() == 0 ? doc.select(selectStr) : doc.select("div.searchlist tbody");

		for (Element eThread : eThreads) {
			Thread thread = toThreadObj(eThread);
			if (thread != null) res.threads.add(toThreadObj(eThread));
		}

		int currPage = 1;

		Elements page = doc.select("div.pages > strong");

		if (page.size() > 0) {
			currPage = Integer.valueOf(page.first().text());
		}

		Elements nextPage = doc.select("div.pages > a[href$=&page=" + (currPage + 1) + "]");

		res.hasNextPage = nextPage.size() > 0;
		res.page = currPage;
	}

	private static Thread toThreadObj(Element eThread) {
		Elements eSubject = eThread.select("th.subject");
		Elements eLastPost = eThread.select("td.lastpost em a");
		String lastHref = eLastPost.attr("href");
		String style;
		String type = eSubject.select("em > a[href^=forumdisplay.php]").text();


		if (lastHref != null && lastHref.length() > 0) {
			String id = Utils.getUriQueryParameter(lastHref).get("tid");

			Element _title = eSubject.select("span a[href^=viewthread.php], a[href^=viewthread.php]").first();
			String title = _title.text();
			style = _title.attr("style");
			boolean isNew = eThread.select("th.subject").hasClass("new");
			Elements eAuthor = eThread.select("td.author");
			Elements eUser = eAuthor.select("a");
			String userName = eUser.text();
			String dateStr = eAuthor.select("em").text().trim();
			// if userHref.length() == 0, this thread is closed for some reason.
			String userHref = eUser.attr("href");
			if (userHref.length() == 0) {
				return null;
			}

			String userId = Utils.getUriQueryParameter(userHref).get("uid");
			String commentNum = eThread.select("td.nums > strong").text().trim();

			String forumLink = eThread.select(".forum a").attr("href");

			String fid = null;

			int uid = Integer.valueOf(userId);

			User user = new User().setId(uid).setName(userName);
			Thread ret = new Thread();


			ret.setId(Integer.valueOf(id)).setTitle(title).setNew(isNew)
					.setCommentCount(Integer.valueOf(commentNum)).setAuthor(user).setDateStr(dateStr)
					.setStick(eThread.id().startsWith("stickthread_"))
					.setBold(style.contains("bold"))
					.setType(type);

			Matcher matcher = COLOR_REG.matcher(style);
			if (matcher.find()) ret.setColor(matcher.group());

			if (forumLink.length() > 0) {
				fid = forumLink.substring(forumLink.indexOf("fid=") + 4);
				ret.setFid(Integer.valueOf(fid));
			}

			return ret;
		} else {
			return null;
		}
	}
}
