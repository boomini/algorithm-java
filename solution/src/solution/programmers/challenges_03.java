package solution.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class challenges_03 {
	class town implements Comparable<town>{
		int g;//골드
		int s;//실버
		int w;//무게
		int t;//시간
		public town(int g, int s, int w, int t) {
			super();
			this.g = g;
			this.s = s;
			this.w = w;
			this.t = t;
		}
		@Override
		public int compareTo(town o) {
			// TODO Auto-generated method stub
			return this.t - o.t;
		}
		
		
	}
	class Solution {
	    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
	    	long answer = -1;
	    	ArrayList<town> towns = new ArrayList<town>();
	    	long gsum = 0;
	    	long ssum = 0;
	    	for(int i=0; i<g.length; i++) {
	    		towns.add(new town(g[i],s[i],w[i],t[i]));
	    		gsum += g[i];
	    		ssum += s[i];
	    	}
	    	Collections.sort(towns);
	    	int time = 0;
	    	while(true) {
	    		//1초마다 무게 계산
	    		
	    		
	    		time++;
	    		
	    	break;	
	    	}
	    	
	       
	        return answer;
	    }
	}
	public static void main(String[] args) {
		
	}
}
