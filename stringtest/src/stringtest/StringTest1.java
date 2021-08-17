package stringtest;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class StringTest1 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		// 媛앹껜 �깮�꽦諛⑸쾿
		// 1. literal : 臾몄옄�뿴 ���옣�냼 �븷�떦
		String s1 = "�떥�뵾";
		// 2. �깮�꽦�옄 : heap
		String s2 = new String("�떥�뵾");

		// �뿬�윭媛�吏� 諛⑸쾿
		String s3 = new String(); // 鍮덈Ц�옄�뿴.
		byte b[] = { 65, 66, 67, 68, 69, 70, 71, 72, 73 };
		String s4 = new String(b);
		System.out.println("s4: " + s4);
		
		// �궡而�
		String msg = "�븞�뀞�븯�꽭�슂";
		byte[] b2 = msg.getBytes("euc-kr");
		System.out.println(Arrays.toString(b2));
		
		// �긽��諛⑹뺨
		String s5 = new String(b2, "euc-kr");
		System.out.println(s5);
		
		String s6 = new String(b, 3, 4);
		System.out.println(s6);
		
//		char[] c = {'�븞', '�뀞', '�븯', '�꽭', '�슂', '!', '!'};
//		String s7 = new String(c);
//		System.out.println("s7: " + s7);
		
		char[] c2 = msg.toCharArray();
		System.out.println(Arrays.toString(c2));
		
		
		String case1 = "ssAfY";
		String case2 = "SSaFy";
		if(case1.equals(case2))
			System.out.println("臾몄옄�뿴 媛숇떎.");
		if(case1.equalsIgnoreCase(case2))
			System.out.println("���냼臾몄옄 臾댁떆 臾몄옄�뿴 媛숇떎.");
		if(case1.toLowerCase().equals(case2.toLowerCase()))
			System.out.println("���냼臾몄옄 臾댁떆 臾몄옄�뿴 媛숇떎.");
		
		System.out.println(case1.toLowerCase() + " " + case1.toUpperCase());

//		臾몄옄�뿴 �삎蹂��솚.
//		�닽�옄 >> 臾몄옄�뿴
		int x = 123;
		System.out.println(x + 100);
//		1.
		String snum = x + "";
		System.out.println(snum + 100);
//		2.		
		snum = String.valueOf(x);
		System.out.println(snum + 100);
//		3.		
		snum = Integer.toString(x);
		System.out.println(snum + 100);
		
//		臾몄옄�뿴 >> �닽�옄
		String numStr = "123";
		System.out.println(numStr + 100);
		int num = Integer.parseInt(numStr);
		System.out.println(num + 100);
	}
}
