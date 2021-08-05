package modifiertest;

public class PointCardUser {

	int cnt;
	String name;
	public PointCardUser(String name) {
		this.name = name;
	}
	
	public void visit() {
		cnt++;
	}
}
