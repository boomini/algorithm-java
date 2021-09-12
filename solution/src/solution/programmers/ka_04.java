package solution.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Solution9 {
	static int N=11, R;
	static int[] numbers;
	static int[] input;
	static int sum;
	static int targetsum;
	static int answersum;
	static int check[];
	static int answer[];
    public int[] solution(int n, int[] info) {
    	input = info;
    	targetsum = 0;
    	R=n;
		numbers = new int[n];
		answer = null;
		answersum = -1;
		combination(0,0);
		//System.out.println(answersum);
		//System.out.println(Arrays.toString(answer));
		if(answersum==-1) {
			return new int[] {-1};
		}
		int realanswer[] = new int[11];
		
		for(int i=0; i<answer.length; i++) {
			realanswer[answer[i]]++;
		}
		//System.out.println(Arrays.toString(realanswer));
        return realanswer;
    }
    private static void combination(int cnt, int start) {
		if(cnt==R) {
			check = new int[11];
			sum = 0;
			targetsum = 0;
			for(int i=0; i<R; i++) {
				check[numbers[i]]++;
			}
			for(int i=0; i<N; i++) {
				if(check[i]>input[i]) {
					sum+=10-i;
				}else if(check[i]==0 && input[i] == 0 ){
					continue;
				}
				else {
					targetsum+=10-i;
				}
			}
			//System.out.println(Arrays.toString(numbers) + " " + sum + " " + targetsum);
			if(sum>targetsum) {
				if(sum>answersum) {
					answersum = sum;
					answer = numbers.clone();
					//System.out.println(Arrays.toString(answer) + " " + Arrays.toString(numbers));
				}else if(sum==answersum) {
					List<Integer> list = new ArrayList<>();
					List<Integer> list2 = new ArrayList<>();
					for(int i=0; i<R; i++) {
						list.add(numbers[i]);
						list2.add(answer[i]);
					}
					for(int i=10; i>=0; i--) {
						if(Collections.frequency(list, i)>Collections.frequency(list2, i))
						answer = numbers.clone();
						else if(Collections.frequency(list, i)==Collections.frequency(list2, i))
						continue;
						else break;
					}
				}
			}
			return;
		}
		for(int i = start; i<N; i++) {
			
			numbers[cnt] = i;
			combination(cnt+1,i);
			
		}
	}
}
public class ka_04 {
	
	
	public static void main(String[] args) {
		Solution9 sol = new Solution9();
		System.out.println(sol.solution(5, new int[] {2,1,1,1,0,0,0,0,0,0,0}));
		System.out.println(sol.solution(1, new int[] {1,0,0,0,0,0,0,0,0,0,0}));
		System.out.println(sol.solution(10, new int[] {0,0,0,0,0,0,0,0,3,4,3}));
	}
	
}
