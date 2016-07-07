package blog;

import java.util.Date;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@TypeAlias("cc")
public class DD {

	private int a;
	private String b;
	private long c;
	private Date d;
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public long getC() {
		return c;
	}
	public void setC(long c) {
		this.c = c;
	}
	public Date getD() {
		return d;
	}
	public void setD(Date d) {
		this.d = d;
	}
	@Override
	public String toString() {
		String format=  "DD:[a:%s,b:%s,c:%s,d:%s]";
		return String.format(format, a,b,c,d);
	}
	
	
	
}
