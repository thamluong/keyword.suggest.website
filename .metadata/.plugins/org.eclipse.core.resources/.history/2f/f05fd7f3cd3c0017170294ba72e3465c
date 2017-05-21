package keyword.suggest.website.db.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import keyword.suggest.website.db.Print;
import keyword.suggest.website.db.Url;
import keyword.suggest.website.db.Word;
import keyword.suggest.website.db.common.RequestMappingDefine;
import keyword.suggest.website.db.model.Key;
import keyword.suggest.website.db.service.KeyService;

public class MainController {
	@Autowired
	private KeyService keyService;
	
	List<Key> keys = new ArrayList<Key>();
	/*
	@RequestMapping(RequestMappingDefine.HOME)
	public String home(ModelMap mm) {

		mm.put("keys", keyService.getAllKeys());
		return "index";
	}*/
	
	
	static Map<String, Integer> map = new HashMap<>();
	 
	public static String getContent(String url) throws Exception{
		return Url.getContent(url);
	}

	public static Map<String, Integer> getWords(String content) throws Exception{//Print.print(content);
		return Word.getWords(content);
	}
	
	public static Map<String, Integer> getPhrases(String content) throws Exception{//Print.print(content);
		return Word.getPhrases(content);
	}
	
	public static void main(String args[]) throws Exception{
		System.out.println("********* Start ***********");
		String url = "https://www.tutorialspoint.com/";
		Print.print(getWords(getContent(url)));
		//Print.print(getPhrases(getContent(url)));

		System.out.println("********* Stop ***********");
	}

}
