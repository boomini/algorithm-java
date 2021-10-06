package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class g3_16637 {
 static int N;
	private static int max=(int)(-1e9);
	//max를 0으로 해놔서 틀렸다.
	//결과값이 -일수있기때문에 초기값을 음수 최저값으로 해주어야 한다.
	private static ArrayList<Integer> num = new ArrayList<>();
	private static ArrayList<Character> op = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	N = Integer.parseInt(in.readLine());
	String s = in.readLine();
	for(int i=0; i<N; i++) {
		if(i%2==0) {
			num.add(s.charAt(i)-'0');
		}else {
			op.add(s.charAt(i));
		}
	}
	
	
	dfs(0, num.get(0));
	System.out.println(max);
	}
	private static void dfs(int now, int n) {
		if(now>=op.size()) {
			max=Math.max(max, n);
			return;
		}
		//괄호 안친고
		dfs(now+1, calc(n,now,num.get(now+1)));

		//괄혼친거
		if(now+1<op.size()) {
			int next = calc(num.get(now+1),now+1,num.get(now+2));
			dfs(now+2,calc(n,now,next));
		}
		
	}
	private static int calc(int n1, int oper, int n2) {
		int answer = 0;
		char cop = op.get(oper);
		if(cop=='+') {
			answer = n1+n2;
		}else if(cop=='-') {
			answer = n1-n2;
		}else {
			answer = n1*n2;
		}
		return answer;
	}
	
}
