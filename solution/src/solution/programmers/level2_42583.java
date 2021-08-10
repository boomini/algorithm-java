package solution.programmers;

import java.util.LinkedList;
import java.util.Queue;

class Check {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<int[]> bridge = new LinkedList<int[]>();
        int index = 0;
        while(true) {
        	if(bridge.isEmpty()) {
        		//다리에 차가 없으면 추가
        		bridge.add(new int[] {truck_weights[index],0});
        	}
        	
        }
    }
}

public class level2_42583 {
	
	public static void main(String[] args) {
		Check sol = new Check();
		 int[] weight = new int[] {7,4,5,6};
		 System.out.println(sol.solution(2,10,weight));
	}
	
}
