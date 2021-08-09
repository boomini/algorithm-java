package test;

public class Test {
	public static void main(String[] args) {
		{
			
			String s1 = "Hello";
			String s3 = new String("Hello");
			System.out.println(s1 + " " + s3);
		}
		
		{
			byte b = 10;
			int i=(int)b;
			System.out.println(i);
		}
	}
}
