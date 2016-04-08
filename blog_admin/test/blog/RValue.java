package blog;

public class RValue {

	private String id;
	private long value;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getValue() {
		return value;
	}
	public void setValue(long value) {
		this.value = value;
	}
	@Override
	  public String toString() {
	    return " [id=" + id + ", value=" + value + "]";
	  }
	
}
