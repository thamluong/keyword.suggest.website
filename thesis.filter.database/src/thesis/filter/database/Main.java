package thesis.filter.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Main {

	public static String getContentByUrl(String url){
		
		Document doc;
		String text = "";

		try {
			doc = Jsoup.connect(url).timeout(30000).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.2 (KHTML, like Gecko) Chrome/15.0.874.120 Safari/535.2").get();
			text = doc.text();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return text;
	}

	public static void getWordList(String content){

		Map<String, Integer> map = new HashMap<>();
		List<String> keywords = new ArrayList<String>();
		String[] list = content.split("([\\., ]{1,})|(\\. )");
		String keywords_list_str = "", s = "";
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
				}
			}
		}catch(NullPointerException e){
			System.out.println(e.getMessage());
		}
		System.out.println("count = "+map.size());
		for(String s1: map.keySet())
			System.out.println(s1 + " , "+ map.get(s1) + "\t");
	}

	private static String input(){
		
		System.out.println("Please enter URL to filter data:");
		Scanner in = new Scanner(System.in);
		String url = in.nextLine();
		
		return url;
	}
	
	public static void main (String args[]) throws Exception{
//		String query = "https://www.tutorialspoint.com/";
		
		getWordList(getContentByUrl(input()));

	}
}
