package stringtest;

//문자열 비교.
public class StringTest2 {

	public static void main(String[] args) {
		String s1 = "ssafy";
		String s2 = "ssafy";
		String s3 = new String("ssafy");
		String s4 = new String("Ssafy");
		
		if(s1==s2)
			System.out.println("s1과 s2는 같다");//o
		if(s1==s3)
			System.out.println("s1과 s3는 같다");//x
		if(s1==s4)
			System.out.println("s1과 s4는 같다");//x
		if(s2==s3)
			System.out.println("s2과 s3는 같다");//x
		if(s2==s4)
			System.out.println("s2과 s4는 같다");//x
		if(s3==s4)
			System.out.println("s3과 s4는 같다");//x
		
		System.out.println("---------------------------");
		
		if(s1.equals(s2))
			System.out.println("s1과 s2는 같다.");//o
		if(s1.equals(s3))
			System.out.println("s1과 s3는 같다.");//o
		if(s1.equals(s4))
			System.out.println("s1과 s4는 같다.");//o
		if(s2.equals(s3))
			System.out.println("s2과 s3는 같다.");//o
		if(s2.equals(s4))
			System.out.println("s2과 s4는 같다.");//o
		if(s3.equalsIgnoreCase(s4))
			System.out.println("s3과 s4는 대소문자 무시 문자열이 같다.");//o
	}
}
