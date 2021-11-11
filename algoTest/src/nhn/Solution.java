package nhn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		for(int i=0; i<N; i++) {
			s[i] = in.readLine();
		}
		ArrayList<Integer> check = new ArrayList<Integer>();//merge된 숫자들이 들어갈
		int curnum = 1;
		ArrayList<Integer> answer = new ArrayList<Integer>();//정답이 들어갈
		answer.add(curnum++);
		for(int i=0; i<N; i++) {
			if(s[i].equals("branch")) {
				if(check.size()==0) {
					answer.add(curnum++);
				}else {
					answer.add(check.get(0));
				}
			}else {
				StringTokenizer st = new StringTokenizer(s[i], " ");
				st.nextToken();
				int n = Integer.parseInt(st.nextToken());
				
				check.add(n);
				answer.remove(Integer.valueOf(n));
				Collections.sort(check);
			}
		}
		Collections.sort(answer);
		
		for(int i=0; i<answer.size(); i++) {
			System.out.print(answer.get(i)+" ");
		}
	}
}
