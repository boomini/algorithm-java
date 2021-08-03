package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s5_17478 {
	public static String[] sen = new String[5];
	public static StringBuilder sb = new StringBuilder();
	public static String s = "";
	public static void recursive(int n) {
		
		if(n==0) {
			System.out.print(sb.toString());
			System.out.println(sen[0]);
			System.out.print(sb.toString());
			System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			System.out.print(sb.toString());
			System.out.println(sen[4]);
			return;
		}
		for ( int i=0; i<sen.length; i++) {
			System.out.print(sb.toString());			
			System.out.println(sen[i]);
			
			if(i==sen.length-2) {
				sb.append("____");
				recursive(n-1);
				sb.setLength(sb.length()-4);;
			}
				
		}
	}
	
	public static void fortest(int n) {
		String s = "";
		for(int i=0; i<n; i++) {
			
			for(int j=0; j<sen.length; j++) {
				System.out.println(s + sen[j]);
			}
			s += "--";
		}
	}
	public static void sentence() {	
		sen[0] = "\"재귀함수가 뭔가요?\"";
		sen[1] = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
		sen[2] = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
		sen[3] = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
		sen[4] = "라고 답변하였지.";				
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(sb.readLine());
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		sentence();
		recursive(count);
	}
}
