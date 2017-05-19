package keyword.suggest.website.db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import keyword.suggest.website.db.dao.KeyDao;
import keyword.suggest.website.db.model.Key;

@Service
@Transactional
public class KeyServiceImpl  implements KeyService{

	@Autowired
	private KeyDao keyDao;

	@Override
	public void check(){
		keyDao.check();
	}
	
	@Override
	public List<Key> getAllKeys(){
		return keyDao.findAllKeys();
	}
}
