package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class g4_17135 {
	private static int M;
	private static int N;
	private static int D;
	private static int max= 0;
	private static int arr[] = new int[3];
	private static ArrayList<int[]> enemy;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		enemy = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			s = in.readLine();
			st = new StringTokenizer(s, " ");
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1) {
					enemy.add(new int[] { i, j });
				}
			}
		}

		combination(0, 0);
		System.out.println(max);
	}

	private static void combination(int cnt, int start) {
		if (cnt == 3) {
			forCalc();
			return;
		}
		for (int i = start; i < M; i++) {
			arr[cnt] = i;
			combination(cnt + 1, i + 1);
		}

	}

	private static void forCalc() {
		int close = 0;
		int arri = N;
		ArrayList<int[]> copyEnemy = new ArrayList<>();
		copyEnemy.addAll(enemy);
		int success = 0;
		while(!copyEnemy.isEmpty()) {
			ArrayList<Integer> attack = new ArrayList<>();
			for(int i=0; i<3; i++) attack.add(-1);
			for (int i = 0; i < 3; i++) {
				int mink = Integer.MAX_VALUE;
				int checkj = Integer.MAX_VALUE;
				for(int j=0; j<copyEnemy.size(); j++) {
					int minusX = Math.abs(arri-copyEnemy.get(j)[0]-close);
					if(minusX>D) continue; //x의 차이가 거리보다 크면 해당 x
					
					int minusY = Math.abs(arr[i]-copyEnemy.get(j)[1]);
					if(minusY>D) continue;//y의 차이가 거리보다 크면 해당 x
					
					int k = minusX + minusY;
					if(k>D) continue; //차이가 거리보다 크면 해당 x
					
					if(mink<k) {
						continue;
					}else if(mink>k) {
						attack.set(i,j);
						checkj = copyEnemy.get(j)[1];
						mink = k;
						//최소거리의 값 구하기
					}else {
						if(checkj>copyEnemy.get(j)[1]) {
							attack.set(i,j);
							
							checkj = copyEnemy.get(j)[1];
						}
						//만약 최소거리가 같을시 가장 왼쪽의 값
					}
									
				}
			}
			Set<Integer> set = new HashSet<Integer>(attack);//같은곳 공격 지우기
			attack = new ArrayList<>(set);
			Collections.sort(attack, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2.intValue() - o1.intValue();
				}
			});
			for(int i=0; i<attack.size(); i++) {
				if(attack.get(i)==-1)continue;
				int num = attack.get(i);
				copyEnemy.remove(num);
				success++;
			}//성공한 공격만큼 더해주기
			int size = copyEnemy.size();
			for(int i=size-1; i>=0; i--) {
				if(copyEnemy.get(i)[0]==N-1-close) copyEnemy.remove(i);
				else break;
			}//맨 아래 적들 제거
			set.clear();
			close++;
			
			
		}
		max = success>max?success:max;
	}
}
