package solution.swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d3_6808_02 {
	private static int perCard[];
	private static int myCard[];
	private static int youngCard[];
	private static int win;
	private static int lose;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			int []card = new int[19];
			perCard = new int[10];
			win = 0;
			lose = 0;
			String s = in.readLine();
			StringTokenizer st = new StringTokenizer(s, " ");
			youngCard = new int[10];
			for(int i=1; i<=9; i++) {
				int num = Integer.parseInt(st.nextToken());
				card[num] = 1;
				youngCard[i] = num;
			}
			myCard = new int[10];
			int j =1;
			for(int i=1; i<=18; i++) {
				if(card[i]==0) {
					myCard[j++] = i;
				}
			}
			permutation(1,1);
			sb.append(win).append(" ").append(lose).append("\n");
			
			
		}
		System.out.println(sb.toString());
	}

	private static void permutation(int cnt, int flag) {
		if(cnt==10) {
			int youngScore = 0;
			int myScore = 0;
			//System.out.println(Arrays.toString(perCard));
			for(int i=1; i<=9; i++) {
				int youngNum = youngCard[i];
				int myNum = perCard[i];
				int sumScore = youngNum + myNum;
				if(youngNum > myNum) {
					youngScore += sumScore;
				}else if(youngNum < myNum) {
					myScore += sumScore;
				}
			}
			
			if(youngScore > myScore) win++;
			else if(myScore> youngScore) lose++;
			return;
		}
		for(int i=1; i<=9; i++) {
			if((flag & 1<<i)!=0) continue;
			perCard[cnt] = myCard[i];
			
			permutation(cnt+1, flag | 1<<i);

		}
		
	}
}
