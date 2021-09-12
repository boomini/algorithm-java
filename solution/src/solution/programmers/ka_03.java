package solution.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Solution8{
	class record implements Comparable<record>{
		int num;
		int intime;
		int cnt;
		boolean flag;
		public record(int num) {
			super();
			this.num = num;
		}
		@Override
		public int compareTo(record o) {
			// TODO Auto-generated method stub
			return this.num-o.num;
		} 
		
	}
	 public int[] solution(int[] fees, String[] records) {
	        
	        List<record> car = new ArrayList<record>(); 
	        List<Integer> carnums = new ArrayList<Integer>(); 
	        for(int i=0; i<records.length; i++) {
	        	String s= records[i];
	        	StringTokenizer st = new StringTokenizer(s, " ");
	        	StringTokenizer st2 = new StringTokenizer(st.nextToken(), ":");
	        	int hour = Integer.parseInt(st2.nextToken());
	        	int minute = Integer.parseInt(st2.nextToken());
	        	int time = hour * 60 + minute;
	        	int carnum = Integer.parseInt(st.nextToken());
	        	int index = 0;
	        	if(carnums.contains(carnum)) {
	        		index = carnums.indexOf(carnum);
	        	}else {
	        		car.add(new record(carnum));
	        		carnums.add(carnum);
	        		index = car.size()-1;
	        	}
	        	
	        	
	        	if(st.nextToken().length()==2) {
	        		car.get(index).intime = time;
	        		car.get(index).flag = true;
	        	}else {
	        		car.get(index).cnt += (time - car.get(index).intime);
	        		car.get(index).intime = 0;
	        		car.get(index).flag = false;
	        		
	        	}   	
	        }
	        Collections.sort(car);
	        int[] answer = new int[car.size()];
	        for(int i=0; i<car.size(); i++) {
	        	int time = car.get(i).cnt;
	        	if(car.get(i).flag) {
	        		time+=(1439 - car.get(i).intime);
	        	}
	        	if(time<=fees[0]) {
	        		answer[i] = fees[1];
	        	}else{
	        		answer[i] = fees[1] + (int)Math.ceil((double)(time-fees[0])/fees[2]) * fees[3]; 
	        	}
	        	
	        	
	        }
	        //System.out.println(Arrays.toString(answer));
	        return answer;
	    }
}
public class ka_03 {
	public static void main(String[] args) {
		Solution8 sol = new Solution8();

		System.out.println(sol.solution(new int[] {1, 461, 1, 10}, new String[] {"00:00 1234 IN"}));
	}
}
