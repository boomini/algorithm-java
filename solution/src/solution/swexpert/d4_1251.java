package solution.swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class d4_1251 {
	private static boolean [] isSelected;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			int V = Integer.parseInt(in.readLine());
			int[][] arrV = new int[V][2];
			isSelected = new boolean[V];
			double min[] = new double[V];
			
			Arrays.fill(min, Double.MAX_VALUE);
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for(int i=0; i<V; i++) {
				arrV[i][0] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(in.readLine(), " ");
			for(int i=0; i<V; i++) {
				arrV[i][1] = Integer.parseInt(st.nextToken());
			}
			
			double E = Double.parseDouble(in.readLine());
			min[0] = 0;
			int current = 0;
			int cnt = 0;
			double value = 0;
			for(int v=0; v<V; v++){
				//가장 최소 정점을 고른다.
				double minValue = Double.MAX_VALUE; 
				for(int i=0; i<V; i++) {
					if(!isSelected[i] && minValue>min[i]) {
						current = i;
						minValue = min[i];
					}
				}
				isSelected[current] = true;
				value += minValue;
				//현재 고른 정점에서 최소비용의 정점을 구한다.
				for(int i=0; i<V; i++) {
					if(!isSelected[i]) {		
						long distance = (long) (Math.pow(arrV[current][0]-arrV[i][0],2)+Math.pow(arrV[current][1]-arrV[i][1],2));
						if(distance<min[i]) {
							min[i] = distance;
						}
					}
				}
			}
			
			sb.append(Math.round(value*E)).append("\n");
			
			
		}
		System.out.println(sb.toString());
		
		
	}
}
