package sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 함수에 입력되는 시간은 12시간 표기법으로, AM/PM과 함께 표기됩니다.

24시간 표기법으로 풀이하면 다음과 같습니다.

00:00:00 ~ 11:59:59 --> AM 00:00:00 ~ AM 11:59:59
12:00:00 ~ 23:59:59 --> PM 00:00:00 ~ PM 11:59:59

입력된 첫번째 시간에서 두번째 시간이 되는데 걸리는 시간을 구하는 함수를 구현하시오.

(AM 00:00:01, AM 00:00:02) 가 입력되면, 첫번째 시간에서 두번째 시간이 되기까지 걸리는 시간은 1초 이므로 00:00:01 리턴됩니다.
(PM 01:00:00, AM 01:00:00) 가 입력되면, 첫번째 시간에서 두번째 시간이 되기까지 걸리는 시간은 12시간 이므로 12:00:00이 리턴됩니다.

*조건1: 입력시간값은 valid합니다.
*조건2: AM 00:00:00은 입력되지 않습니다.
*조건3: Date, time, difftime 등 시스템 제공 class/function 사용하지 않아야 합니다.

 */
public class sol3 {
	public static String solution(String start, String end) {
		StringTokenizer st = new StringTokenizer(start, " ");
		String startString = st.nextToken();
		String startTime = st.nextToken();
		//시작시간
		
		
		st = new StringTokenizer(end, " ");
		String endString = st.nextToken();
		String endTime = st.nextToken();
		//끝나는시간
		
		st = new StringTokenizer(startTime, ":");
		int shour = Integer.parseInt(st.nextToken());
		int smin = Integer.parseInt(st.nextToken());
		int ssec = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(endTime, ":");
		int ehour = Integer.parseInt(st.nextToken());
		int emin = Integer.parseInt(st.nextToken());
		int esec = Integer.parseInt(st.nextToken());
		
		String ans="";
		if(startString.equals(endString)) {
			
			//1. AM/PM이 같은경우
			ans = calc(shour, smin, ssec, ehour, emin, esec);
		}else if(startString.equals("AM")&&endString.equals("PM")) {
			//2. AM/PM
			ans =calc(shour, smin, ssec, ehour+12, emin, esec);
		}else if(startString.equals("PM")&&endString.equals("AM")) {
			//3. PM/AM
			ans =calc(shour+12, smin, ssec, ehour+24, emin, esec);
		}
		return ans;
	}

	
	private static String calc(int shour, int smin, int ssec, int ehour, int emin, int esec) {
		int hour = 0;
		int min = 0;
		int sec = 0;
		if(esec-ssec<0) {
			sec = 60+(esec-ssec);
			smin-=1;
		}else {
			sec = esec-ssec;
		}
		
		if(emin-smin<0) {
			min = 60+(emin-smin);
			shour-=1;
		}else {
			min = emin-smin;
		}
		
		hour = ehour-shour;
		
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(hour).append(":");
		if(min<10) {
			sb.append("0");
		}
		sb.append(min).append(":");

		
		if(sec<10) {
			sb.append("0");
		}
		sb.append(sec);

		
		return sb.toString();
		
	}


	public static void main(String[] args) throws IOException {
		System.out.println(solution("AM 00:00:00", "AM 11:59:59"));
		System.out.println(solution("PM 01:00:00", "AM 01:00:00"));
		System.out.println(solution("PM 02:27:00", "AM 07:23:00"));
	}

}
