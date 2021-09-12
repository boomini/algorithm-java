package solution.programmers;

import java.util.StringTokenizer;

class Solution7{
	public int solution(int n, int k) {
        String check ="";
        while(n>0) {
        	check = (n%k) + check;
        	n/=k;
        }
        StringTokenizer st = new StringTokenizer(check, "0");
        int cnt = 0;
		outer : while(st.countTokens() != 0) {
			long num = Long.parseLong(st.nextToken());
			System.out.println(num);
			if(num==1) continue;
			else if(num==2) {
				cnt++;
				continue;
			}
			else {
				for(long i=2; i<=Math.sqrt(num); i++) {
					if(num%i==0) {
						continue outer;
					}
				}
			}
        	cnt++;
        } 
        return cnt;
    }
}
public class ka_02 {
	public static void main(String[] args) {
		Solution7 sol = new Solution7();
		//System.out.println(sol.solution(437674, 3));
		//System.out.println(sol.solution(110011, 10));
		//System.out.println(sol.solution(111111, 10));
		//System.out.println(sol.solution(1093, 3));
		System.out.println(sol.solution(999999999, 5));
	}
}
