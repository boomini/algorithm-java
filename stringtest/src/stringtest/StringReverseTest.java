package stringtest;

public class StringReverseTest {
	public static void main(String[] args) {
		String str = "!!! yfass olleh";
		//String str = "!! 피싸 녕안";
		//1.
		int len = str.length();
		for(int i = len -1; i>=0; i--)
			System.out.println(str.charAt(i));
		System.out.println();
		
		//2.
		String result = "";
		for(int i = len -1; i>=0; i--)
			result += str.charAt(i);
		System.out.println(result);
		System.out.println("reverse한 문자열에서 'o'는" + result.indexOf('o') + "번째 입니다.");
		
		//3.
		byte[] b= str.getBytes();
		byte[] rb = new byte[len];
		int k = 0;
		for(int i = len - 1; i>=0; i--)
			rb[k++] = b[i];
		String rs = new String(rb);
		System.out.println(rs);
		
		//4.
		char[] c = str.toCharArray();
		char[] rc = new char[len];
		k = 0;
		for(int i = len - 1; i>=0; i--)
			rc[k++] = c[i];
		rs = new String(rc);
		System.out.println(rs);
		//hello ssafy !!!
		//안녕 싸피 !!!
		//
		//reverse한 문자열에서 'o'는 몇번째 index입니까.
		
		System.out.println();
	}
}
//stringbuffer와 stringbuilder의 차이
//stringbuffer는 데이터의 안정성이 보장되고
//stringbuilder는 안정성이 보장안된다.
//하지만 builder가 빠르다. builder는 동기화가 보장이 안된다.


