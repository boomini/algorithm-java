package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class g5_1759 {
	//암호만들기
	//암호는 서로다른 L개의 알파벳 소문자
	//최소 한개의 모음, 최소 두개의 자음
	//암호를 이루는 알파벳이 암호에서 증가하는 순서로 배열되었다.

	private static int L;
	private static int C;
	private static String[] pw;
	private static List<String> arr ;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		pw = new String[L];
		arr = new ArrayList<String>();
		s = in.readLine();
		st = new StringTokenizer(s, " ");
		for(int i=0; i<C; i++) {
			arr.add(st.nextToken());
		}

		Collections.sort(arr);
		
		combination(0,0);
	}
	private static void combination(int cnt, int start) {
		if(cnt==L) {
			//System.out.println(Arrays.toString(pw));
			int check1 = 0;
			int check2 = 0;
			
			for(int i=0; i<L; i++) {
				String s = pw[i];
				if(s.equals("a")||s.equals("e")||s.equals("i")||s.equals("o")||s.equals("u")) {
					check1++;
				}else {
					check2++;
				}
			}
			if(check1>=1&&check2>=2) {
				for(int i=0; i<L; i++) {
					System.out.print(pw[i]);
				}
				System.out.println();
			}
			return;
		}
		
		for(int i=start; i<C;i++) {
			pw[cnt] = arr.get(i);
			combination(cnt+1, i+1);
		}
		
	}
}
