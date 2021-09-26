package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p5_1786 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		char[] n = s.toCharArray();
		s = in.readLine();
		char[] p = s.toCharArray();
		
		int[] pi = new int[p.length];
		//패턴배열만들기
		for(int i=1, j=0; i<p.length; i++) {
			while(j>0 && p[i] != p[j]) {
				j = pi[j-1];
			}
			if(p[i]==p[j]) {
				pi[i] = ++j;
			}
			else
				pi[i] = 0;
		}
		
		int cnt = 0;
		ArrayList<Integer> answer = new ArrayList<Integer>();
		int size = p.length;
		for(int i=0, j=0; i<n.length; ++i) {
			while(j>0 && n[i] != p[j]) {
				j = pi[j-1];
			}
			
			if(n[i]==p[j]) {
				if(j==size-1) {
					cnt++;
					j = pi[j];
					answer.add((i+1) - p.length+1);
				}else {
					//패턴 일치 중간 과정(패턴 앞쪽 일치하며 진행중인 상황)
					j++;
				}
				
			}
		}
		System.out.println(cnt);
		for(int i=0; i<answer.size(); i++) {
			System.out.println(answer.get(i));
		}
	}
}
