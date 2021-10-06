package solution.programmers;

import java.util.ArrayList;


class Solution4 {
    public int[] solution(int[] lottos, int[] win_nums) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int[] answer = new int[2];
        for(int i=0; i<6; i++) {
        	arr.add(win_nums[i]);
        }
        int cntz = 0;
        int cnt =0;
        for(int i=0; i<6; i++) {
        	if(lottos[i]==0)cntz++;
        	else if(arr.contains(lottos[i]))cnt++;
        }
        answer[0]=7-(cnt+cntz)>5?6:7-(cnt+cntz);
        answer[1]=7-cnt>5?6:7-cnt;
        
        return answer;
    }
}
public class level1_77484 {
	public static void main(String[] args) {
		Solution4 sol = new Solution4();
		System.out.println(sol.solution(new int[] {44, 1, 0, 0, 31, 25}, new int[] {31, 10, 45, 1, 6, 19}));
	}
}
