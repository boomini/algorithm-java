package modifiertest;

public class Store {
	public static void main(String[] args) {
		Guest g1 = new Guest("심아윤");
		Guest g2 = new Guest("강진");
		Guest g3 = new Guest("유혜인");
		
		System.out.println(g1.name + "님 방문.");
		g1.visit();
		System.out.println("가게 방문자수 : " +g1.cnt );
	}
}
