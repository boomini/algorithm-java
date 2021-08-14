package solution.test.nexttoss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

class Solution3 {
	public String solution(String input) {
		BufferedReader in = new BufferedReader(new StringReader(input));
		String s = null;
		try {
			s = in.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		StringTokenizer st = new StringTokenizer(s, " ");

		int M = Integer.parseInt(st.nextToken()); // M일 동안
		int N = Integer.parseInt(st.nextToken()); // N회 노출
		StringBuilder sb = new StringBuilder();
		int showCnt = 0;
		int dayCnt = 1;
		int noShowCnt = 0;
		boolean noShow = false;
		sb.append(M).append(" ").append(N).append("\n");
		while (true) {
			try {
				s = in.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (s.equals("EXIT")) {
				sb.append("BYE").append("\n");
				break;
			} else if (s.equals("NEGATIVE") ) {
				sb.append("0").append("\n");
				noShow = true;
				showCnt = 0;
			} else if (s.equals("NEXT")) {
				if (dayCnt == M) {
					dayCnt = 1;
					showCnt = 0;
				}			
				else {
					dayCnt++;
				}
				
				if(noShow) {
					if(noShowCnt == M) {
						noShow = false;
						noShowCnt = 0;
						dayCnt = 1;
					}else {
						noShowCnt++;
					}
					
				}
				sb.append("-").append("\n");
			} else if (s.equals("SHOW")) {
				if (showCnt < N && !noShow) {
					//m날짜 안에서는 show 해주고
					sb.append("1").append("\n");
					showCnt++; 
					if(showCnt == N) noShow = true;
				} 
				else {
					noShow = true;
					showCnt = 0;
					sb.append("0").append("\n");
				}
			} else {
				sb.append("ERROR").append("\n");
			}
		}
		return sb.toString();
	}
}

public class challenge4 {
	public static void main(String[] args) {
	String s="1 2\nSHOW\nSHOW\n" + 
			"NEXT\n" + 
			"SHOW\n" + 
			"NEXT\n" + 
			"SHOW\n" + 
			"NEXT\n" + 
			"SHOW\n" + 
			"EXIT";
	Solution3 sol = new Solution3();
	System.out.println(sol.solution(s));
			
			
	}
}
