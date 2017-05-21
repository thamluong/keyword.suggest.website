package keyword.suggest.website.db.dao;

import java.util.List;

import keyword.suggest.website.db.model.Key;

public interface KeyDao {
	
	public void check();
	public List<Key> findAllKeys();
	public void updateContent(List<Key> list);
}
