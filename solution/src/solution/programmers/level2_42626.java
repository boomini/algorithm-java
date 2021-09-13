package solution.programmers;

import java.util.PriorityQueue;

class Solution11 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++) {
        	pq.add(scoville[i]);        	
        }
        
        while(true) {
        	if(pq.peek()>=K) break;
        	int num1 = pq.poll();
        	if(pq.size()==0) return -1;
        	int num2 = pq.poll();
        	
        	pq.add(num1 + num2*2);
        	answer++;
        }
        return answer;
    }
}
public class level2_42626 {
	public static void main(String[] args) {
		Solution11 sol = new Solution11();
		System.out.println(sol.solution(new int[] {1, 2, 3, 9, 10, 12}, 7));
	}
}
