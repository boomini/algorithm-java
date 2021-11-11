package solution.baekjoon;

public class s5_4673 {
	public static void main(String[] args) {
		boolean arr[] = new boolean[10001];
		int idx=1;
		while(idx<10000) {			
			int sum = idx;
			char num[] = String.valueOf(idx).toCharArray();
			for(int i=0; i<num.length; i++) {
				sum += num[i]-'0';
			}
			idx++;
			if(sum>10000) continue;
			arr[sum] = true;			
		}
		
		for(int i=1; i<arr.length; i++) {
			if(!arr[i])System.out.println(i);
		}
	}
}
