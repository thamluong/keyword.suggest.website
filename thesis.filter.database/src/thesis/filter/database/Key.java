package thesis.filter.database;

public class Key {
	private int id;
	private String key;
	
	public Key(){}
	public Key(int id, String key) {
		super();
		this.id = id;
		this.key = key;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	
}
