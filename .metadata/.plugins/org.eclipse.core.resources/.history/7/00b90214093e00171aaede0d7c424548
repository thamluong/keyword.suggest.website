package keyword.suggest.website.db.dao;

import java.util.List;

import org.hibernate.SessionFactory;
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
}
