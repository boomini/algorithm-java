package solution.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class mem{
	String name = null;
	List<Integer> arr = new ArrayList<Integer>();
	public mem(String name) {
		super();
		this.name = name;

	}
	public void add(Integer target) {
		this.arr.add(target);
	};
	
	
}
class Solution6 {
    public int[] solution(String[] id_list, String[] report, int k) {
       
        int n= id_list.length;
        int m = report.length;
        int[] cnt = new int[n];
        mem[] mems = new mem[n];
        int[] answer = new int[n];
        for(int i=0; i<n; i++) {
        	mems[i] = new mem(id_list[i]);
        }
        for(int i=0; i<m; i++) {
        	String s = report[i];
        	StringTokenizer st = new StringTokenizer(s, " ");
        	int index1 = -1;
        	int index2 = -1;
        	String name = st.nextToken();
        	String target = st.nextToken();
        	for(int j=0; j<n; j++) {
        		if(id_list[j].equals(name)){
        			index1 = j;
        		}
        		if(id_list[j].equals(target)){
        			index2 = j;
        		}
        	}
        	if(!mems[index1].arr.contains(index2)) {
        		mems[index1].add(index2);
            	cnt[index2]++;
        	}
        	
        }
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<mems[i].arr.size(); j++){
        		//System.out.println(mems[i].arr.get(j));
        		if(cnt[mems[i].arr.get(j)]>=k) {
        			answer[i]++;
        		}
        	}
        }
        //System.out.println(Arrays.toString(answer));
        return answer;
    }
}
public class ka_01 {
	
	
	public static void main(String[] args) {
		Solution6 sol = new Solution6();
		System.out.println(sol.solution(new String[] {"con", "ryan"} , new String[] {"ryan con", "ryan con", "ryan con", "ryan con"}, 3));
		System.out.println(sol.solution(new String[] {"muzi", "frodo", "apeach", "neo"} , new String[] {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2));
	}
}
