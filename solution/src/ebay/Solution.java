package ebay;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Class{
	int idx;
	String cont;
	boolean possible[][];
	public Class(int idx, String cont, boolean[][] possible) {
		super();
		this.idx = idx;
		this.cont = cont;
		this.possible = possible;
	}
}
public class Solution {
	public static int solution(String[][] schedule) {
        int cnt = 0;
        for(int i=0; i<4; i++) {
        	Queue<Class> q = new LinkedList<Class>();
        	boolean possible[][] = new boolean[5][24];
        	
        	calschedule(schedule[0][i],possible);
        	
        	
        	q.add(new Class(0,schedule[0][i],possible));
        	while(!q.isEmpty()) {
        		int idx = q.peek().idx;
        		boolean[][] available = q.peek().possible;
        		q.poll();
        		if(idx==4) {
        			cnt++;
        			continue;
        		}
        		for(int k=0; k<4; k++) {
        			boolean[][] copyarray = copyarray(available);
        			if(calschedule(schedule[idx+1][k],copyarray)) {
        				q.add(new Class(idx+1,schedule[idx+1][k],copyarray));
        			};
        		}
        		
        	}
        }
        return cnt;
    }
	private static boolean[][] copyarray(boolean[][] available) {
		boolean[][] copyarray = new boolean[5][24];
		for(int i=0; i<available.length; i++) {
			copyarray[i] = available[i].clone();
		}
		return copyarray;
		
	}
	private static boolean calschedule(String str, boolean[][] possible) {
		StringTokenizer st = new StringTokenizer(str);
		if(str.length()==8) {
    		int d = checkday(st.nextToken());//요일
    		if(!cal(st.nextToken(),possible,6,d))return false;
    		//시간문자, 가능여부배열, 3시간연속일경우=6, 요일
    	}else {//1시간 반씩인 경우.
    		int firstday = checkday(st.nextToken());
    		if(!cal(st.nextToken(),possible,3,firstday))return false;
    		int secday = checkday(st.nextToken());
    		if(!cal(st.nextToken(),possible,3,secday))return false;
    	}
		return true;
	}
	private static boolean cal(String time, boolean[][] possible, int i, int d) {
		StringTokenizer st = new StringTokenizer(time,":");
		int hour = Integer.valueOf(st.nextToken());
		String min = st.nextToken();
		int idx = (hour-9)*2;
		if(min.equals("30")) {
			//30분이면
			idx+=1;
		}		
		for(int p=0; p<i; p++) {
			if(possible[d][idx+p])return false;
			possible[d][idx+p] = true;
		}
		return true;
	}
	private static int checkday(String s) {
		String day[] = {"MO", "TU", "WE", "TH", "FR"};
		for(int d=0; d<day.length; d++) {
			if(s.equals(day[d]))return d;
		}
		return -1;		
	}
	
	public static void main(String[] args) {
		String[][] input = {{"MO 12:00", "MO 12:00", "MO 12:00", "MO 12:00"}, {"MO 12:00", "MO 12:00", "MO 12:00", "MO 12:00"}, {"MO 12:00", "MO 12:00", "MO 12:00", "MO 12:00"}, {"MO 12:00", "MO 12:00", "MO 12:00", "MO 12:00"}, {"MO 12:00", "MO 12:00", "MO 12:00", "MO 12:00"}};
		int ans = solution(input);
		System.out.println(ans);
	}
}
