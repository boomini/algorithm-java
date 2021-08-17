package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1_2839 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		if (N % 5 == 0) {
			//5로 나누어 떨어지면 나누기 5한만큼의 봉지
			System.out.println(N / 5);
		} else {
			//그게 아니면 5으로 나눌 수 있을때까지 나눈 후 나머지가 3으로 나누어 떨어질때까지 체크하면서 봉지계산
			int num = N / 5;
			int check = 0;
			int count = 0;
			while (true) {
				check = N - (num * 5);
				count = num;
				if (check % 3 == 0) {
					count += check / 3;
					break;
				}else if(num==0) {
					count = -1;
					break;
				}
				num--;
			}
			System.out.println(count);
		}

	}
}
