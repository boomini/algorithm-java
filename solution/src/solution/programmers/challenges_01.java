package solution.programmers;

class Solution3 {
    public int solution(int[] numbers) {
        int answer = -1;
        boolean number[] = new boolean[10];
        for(int num : numbers) {
        	if(!number[num]) number[num] = true;
        }
        int sum = 0;
        for(int i=0; i<10; i++) {
        	if(!number[i]) {
        		sum+=i;
        	}
        	
        }
        
        return sum;
    }
}
public class challenges_01 {
	public static void main(String[] args) {
		Solution3 sol = new Solution3();
		System.out.println(sol.solution(new int[] {1,2,3,4,6,7,8,0}));
	}
}
