package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class s2_1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		String num = "";
		int sum=0;
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c=='-') {
				sum+=Integer.valueOf(num);
				arr.add(sum);
				sum=0;
				num="";
			}else if(c=='+') {
				sum+=Integer.valueOf(num);
				num="";
			}else {
				if(num.length()==0&&c=='0') {
					continue;
				}
				else num+=c;
			}
		}
		arr.add(sum+Integer.valueOf(num));
		int ans = arr.get(0);
		for(int i=1; i<arr.size(); i++) {
			ans-=arr.get(i);
		}
		System.out.println(ans);
	}
}
