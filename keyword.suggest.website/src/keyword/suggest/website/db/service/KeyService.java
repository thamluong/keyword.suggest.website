package keyword.suggest.website.db.service;

import java.util.List;

import keyword.suggest.website.db.model.Key;

public interface KeyService {

	public void check();
	public List<Key> getAllKeys();
}
