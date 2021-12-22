package jobssafy;

import java.time.LocalDateTime;

public class year {
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		
		int year = now.getYear();
		int mon = now.getMonthValue();

		int ans[] = {0,31,0,31,30,31,30,31,31,30,31,30,31};
		int ansval=0;
		if(mon==2) {
			if((year%4==0) && ((year % 100!=0)||(year % 400==0))) ansval = 29;
			else ansval=28;
		}else {
			ansval = ans[mon];
		}
		System.out.println(ansval+"days for "+year+"-"+mon);
	}
}
