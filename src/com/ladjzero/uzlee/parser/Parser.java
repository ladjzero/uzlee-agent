package com.ladjzero.uzlee.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by chenzhuo on 16-2-11.
 */
public abstract class Parser {
	public static final String CODE_GBK = "GBK";
	public static final String CODE_UTF8 = "UTF-8";

	private static final String STATS = "论坛统计";
	private String mCode = CODE_GBK;

	public static Document getDoc(InputStream html, ResponseData res) throws IOException {
		long time = System.currentTimeMillis();

		Document doc = Jsoup.parse(html, CODE_GBK, "www.hi-pda.com");

		try {
			int msgCount = 0;

			for (Element a : doc.select("#prompt_pm, #prompt_announcepm, #prompt_systempm, #prompt_friend, #prompt_threads")) {
				String msgText = a.text();

				int _index = msgText.indexOf("("),
						index_ = msgText.indexOf(")");

				if (index_ > _index) {
					msgCount += Integer.valueOf(msgText.substring(_index + 1, index_));
				}
			}

			res.unread = msgCount;

			Elements eUser = doc.select("#umenu > cite > a");
			String uidHref = eUser.attr("href");
			String uid = Utils.getUriQueryParameter(uidHref).get("uid");

			if (uid != null && uid.length() > 0) {
				int id = Integer.valueOf(uid);
				String name = eUser.text().trim();

				res.currentUser = new User().setId(id).setName(name);
			}
		} catch (Error e) {
//			Logger.e(TAG, e.toString());
		}

		Elements formHashInput = doc.select("input[name=formhash]");

		if (formHashInput.size() > 0) {
			res.formhash = formHashInput.val();
		}

		Elements hashInput = doc.select("input[name=hash]");

		if (hashInput.size() > 0) {
			res.hash = hashInput.val();
		}

		String stats = doc.select("#footlink a[href=stats.php]").text();

//		if (!stats.equals(STATS)) mCode = mCode.equals(CODE_GBK) ? CODE_UTF8 : CODE_GBK;

//		Logger.i("%d ms", System.currentTimeMillis() - time);
		return doc;
	}

	public static String[] parseExistedAttach(InputStream html, ResponseData data) throws IOException {
		Document doc = getDoc(html, data);

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

		return attachIds.toArray(new String[0]);
	}
}