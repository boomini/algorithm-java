package stringtest;

import java.util.Arrays;

public class StringTest3 {
	public static void main(String[] args) {
		String str = "hello ssafy !!!";
		char c = str.charAt(1);
		System.out.println("c: " + c);
		
		System.out.println(str.concat("@@@"));
		System.out.println(str);
		
		//equals : =
		//contains : like (wildcard : % _)
		if(str.contains("ss"))
			System.out.println("ss포함");
		
		if(str.startsWith("hello"))
			System.out.println("hello시작!!");
		if(str.endsWith("!!"))
			System.out.println("!!로 끝!!");
		
		System.out.println(str + "에서 s는 " + (str.indexOf('s')+1) + "번째에 있다.");
		System.out.println(str + "에서 마지막 s는 " + (str.lastIndexOf('s')+1) + "번째에 있다.");
		System.out.println(str + "에서 ssafy는 " + (str.indexOf("ssafy")+1) + "번째에 있다.");
	
		System.out.println("str은 빈문자열? " + str.isEmpty());
		System.out.println("str은 문자열 길이 " + str.length());
		str = "  he  ll o s s a f  y";
		System.out.println("str 문자열 길이 : " + str.length());
		System.out.println("str 문자열 길이 : " + str.trim().length()); //앞 뒤 공백제거 //중간 공백은 제거 안됨.
		
		str = "hello jaba !!!";
		System.out.println(str.replace('b', 'v'));
		System.out.println(str.replace("jaba", "java"));
		System.out.println(str.replace("jaba", "java"));
		System.out.println(str);
		
		String s[] = str.split("a"); //데이터 더 많이잡아먹는다.
		System.out.println(Arrays.toString(s));
		
		System.out.println(str.substring(6,10));
		System.out.println(str.substring(6));
	}
}
