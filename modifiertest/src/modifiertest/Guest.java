package modifiertest;

public class Guest {

	int cnt;
	String name;
	public Guest(String name) {
		this.name = name;
	}
	
	public void visit() {
		cnt++;
	}
}
