package thesis.filter.database;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//import google.search.result.UrlSource;

public class KeywordCounts {

	//num is the number of GG searched result, "tbm=" means search All, "tbm=vid" means search with only video
	//"q="+str is to fill keyword here
	final static String prefix = "https://www.google.com.vn/search?num=10&tbm=&q=";
	private static Map<String, Integer> map = new HashMap<>();
	private static List<String> keywords = new ArrayList<String>();
	private static String keywords_list_str = "";

	public static List<String> getSearchedKeywordsLinks(String query) throws Exception {

		return getWebpageLinks(prefix+URLEncoder.encode(query, "UTF-8"));
	}

	public static String getContentByUrl(String url){
		List<String> result = new ArrayList<String>();
		Document doc;
		String text = "";
		//List<KeyRate> keysList = new ArrayList<KeyRate>();
		List<String> list = new ArrayList<String>();

		try {
			doc = Jsoup.connect(url).timeout(30000).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.2 (KHTML, like Gecko) Chrome/15.0.874.120 Safari/535.2").get();
			text = doc.text();
			//System.out.println("text = "+text);
			//			System.out.println("body = "+doc.body());// return html of url
			//			System.out.println("outerHTML = "+doc.outerHtml());// return all of html + javascript of url

			//			System.out.println("title = "+doc.title());// return title
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return text;
	}

	public static void getWordList(String content){


		String[] list = content.split("([\\., ]{1,})|(\\. )");
		String s = "";
		try { 
			for(String s1 : list){
				s = s1.toLowerCase();
				if (s.matches("\\d+")) continue;
				if(keywords_list_str.contains(s) == false){ 
					map.put(s, 1);
					keywords_list_str += ", "+ s;
				}
				else {
					int x = map.get(s);
					map.replace(s, x + 1);
					//System.out.println(s + " , "+ map.get(s) + "\t");
				}
			}
		}catch(NullPointerException e){
			System.out.println(e.getMessage());
		}
		System.out.println("count = "+map.size());
		/*for(String s1: map.keySet())
			System.out.println(s1 + " , "+ map.get(s1) + "\t");*/
			//System.out.println(s1);
	}

	public static void getWordListInRecursiveUrl(String url){
		List<String> urls = getWebpageLinks(url);

		for(String u : urls){
			getWordList(getContentByUrl(u));
		}
	}
	public static void getUrlListByUrl(String url){
		List<String> result = new ArrayList<String>();
		String[] keys ;
		Document doc;
		String text, reg = "//\\..*/$", temp;
		//List<KeyRate> keysList = new ArrayList<KeyRate>();
		List<String> list = new ArrayList<String>();

		try {
			doc = Jsoup.connect(url).timeout(30000).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.2 (KHTML, like Gecko) Chrome/15.0.874.120 Safari/535.2").get();
			text = doc.text();

			result = getWebpageLinks(url);
			for (String s: result){
				keys = s.split("(http://)|(https://)|(www.)|(.com)|(.org)|[/ . | - | _]");
				for(String s1 : keys){
					//System.out.print(s1+", ");
					if(!list.contains(s1)) list.add(s1);
				}
			}
			for(String s1 : list)
				System.out.print(s1+", ");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static List<String> getWebpageLinks(String url){

		List<String> links = new ArrayList<String>();
		Document doc;
		try {
			doc = Jsoup.connect(url).timeout(30000).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.2 (KHTML, like Gecko) Chrome/15.0.874.120 Safari/535.2").get();

			Elements link = doc.body().select("a[href]");
			for (Element l : link) {

				String temp = l.attr("href");
				if ((temp.startsWith("http") || temp.startsWith("com") || temp.startsWith("org")) 
						&& (!temp.contains("google") && !temp.contains("youtube"))){ 
					links.add(temp);
					//System.out.println("" +temp);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return links;

	}
	public static void main (String args[]) throws Exception{
		KeywordCounts urlSource = new KeywordCounts();
		String url = "https://www.tutorialspoint.com/";
		//String result = getContentByUrl(url);
		//getUrlListByUrl(url);
		//getWebpageLinks(url);
		//getWordList(getContentByUrl(url));
		getWordListInRecursiveUrl(url);
		for(String s1: map.keySet())
			System.out.println(s1 + " , "+ map.get(s1) + "\t");

	}
}
