package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s4_1244 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(in.readLine());
		String forArray = in.readLine();
		
		char [] array = forArray.toCharArray();
		System.out.println(array[0] + " " + array[1]);
		int student = Integer.parseInt(in.readLine());
		int [][] studentArray = new int [student][student]; 
		
		for ( int i=0; i<student; i++) {
			String num = in.readLine();
			array = num.toCharArray();
			studentArray[i][0] = array[0];
			studentArray[i][1] = array[1];
		}
		
	}
}
