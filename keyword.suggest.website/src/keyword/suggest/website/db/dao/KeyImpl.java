package keyword.suggest.website.db.dao;

import java.io.IOException;
import java.util.List;

import org.hibernate.SessionFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import keyword.suggest.website.db.model.Key;

@Repository
@SuppressWarnings("unchecked")
public class KeyImpl  implements KeyDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void check(){
		List<Key> list = sessionFactory.getCurrentSession().createQuery("from KEY").list();
		System.out.println("size = "+list.size());
		for(Key s : list)
			System.out.println("comp = "+s.getName());
	}

	@Override
	public List<Key> findAllKeys(){

		return sessionFactory.getCurrentSession().createQuery("from KEY").list();
	}
	
	@Override
	public void updateContent(List<Key> list){
		sessionFactory.getCurrentSession().saveOrUpdate(new Key(null, "ORM", "5"));
	}
	
	private String findContent(String url) throws IOException{

		Document doc;
		String text = "";

		doc = Jsoup.connect(url).timeout(30000)
				.userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.2 (KHTML, like Gecko) Chrome/15.0.874.120 Safari/535.2")
				.get();
		text = doc.text(); //return content in interface webpage

		//			System.out.println("body = "+doc.body());// return html of url
		//			System.out.println("outerHTML = "+doc.outerHtml());// return all of html + javascript of url
		//			System.out.println("title = "+doc.title());// return title

		return text;
	
	
	}
}
