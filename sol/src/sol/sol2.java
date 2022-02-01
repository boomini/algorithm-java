package sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


class alphabet implements Comparable<alphabet>{
	int i;
	int cnt;
	
	public alphabet(int i) {
		super();
		this.i = i;
		this.cnt = 0;
	}

	@Override
	public int compareTo(alphabet o) {
		//많은순, 알파벳순으로 정렬
		if(o.cnt==this.cnt) {
			return this.i-o.i;
		}else {
			return o.cnt-this.cnt;
		}	
	}
	
}
public class sol2 {
/*
 * 스트링 s가 주어집니다. 
스트링 s는 알파벳 소문자('a'~'z')와 대문자('A'~'Z')로만 이루어져 있습니다. 
우리는 스트링 s에서 가장 많이 쓰인 알파벳을 찾아 해당 알파벳을 return 하는 solution 함수를 구현하려고 합니다. 이때, 소문자와 대문자는 같다고 판단합니다. 또한, 가장 많이 쓰인 알파벳을 반환할 때는 소문자로 반환하고, 가장 많이 쓰인 알파벳이 2개 이상이면 알파벳 순서대로 스트링을 이루어 반환합니다.

예를 들면 아래 표와 같이 정리할 수 있습니다.

s	answer	<비고>
-----------------------------
"aAb"	"a"	대소문자가 같기때문에, a
"BA"	"ab"	수가 같다면, 순서대로 정렬해야 한다
"BbA"	"b"	대소문자가 같기때문에, b

문자열이 매개변수 s로 주어졌을 때, 가장 많이 쓰인 알파벳을 찾아 해당 알파벳을 return 하는 solution 함수를 구현해 보세요. 

 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<alphabet> arr = new ArrayList<alphabet>();
		for(int i=0; i<26; i++) {
			arr.add(new alphabet(i));
		}
		String s = in.readLine();
		char chrarray[] = s.toCharArray();
		//string char배열
		
		for(int i=0; i<chrarray.length; i++) {
			if(chrarray[i]<97) {
				arr.get(chrarray[i]-65).cnt++;
			}else {
				arr.get(chrarray[i]-97).cnt++;
			}
		}
		
		Collections.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		int max = arr.get(0).cnt;
		for(int i=0; i<26; i++) {
			if(max==arr.get(i).cnt) {
				sb.append((char)(arr.get(i).i+97));
			}else {
				break;
			}
			
		}
		System.out.println(sb.toString());
		
	}
}
