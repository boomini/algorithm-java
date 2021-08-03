package solution.swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class d3_1289 {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);;
		int sw = scanner.nextInt();
		int [] array = new int [sw];
		for(int i=0; i< sw; i++) {
			array[i] = scanner.nextInt();
		}
		int student = scanner.nextInt();
		int [][] students = new int [student][2];
		for(int i=0; i<student; i++) {
			students[i][0] = scanner.nextInt();
			students[i][1] = scanner.nextInt();
			
		}
		
		for(int i=0; i<student; i++) {
			int check = (students[i][1]);
			int index = 0;
			if(students[i][0]==1) {
				int num=1;
				while(true) {
					int multiple = check*num;
					index = multiple - 1;

					if(index>sw-1) break;
					if(array[index]==0) {
						array[index]=1;
					}
					else{
						array[index]=0;
					}
					num++;
				}
			}
			else if(students[i][0]==2) {
				int num=0;
				while(true) {
					index = check-1;
					int num1 = index-num;
					int num2 = index+num;
					if(num1<0 || num2 >sw-1) break;
					if(array[num1]==array[num2] ) {
						if(array[num1]==0) {
							array[num1] = 1;
							array[num2] = 1;
						}
						else if(array[num1] == 1) {
							array[num1] = 0;
							array[num2] = 0;
						}
					}
					else break;
					num++;
				}
			}

		}
		for(int k=0; k<array.length; k++) {
			System.out.print(array[k] + " ");
			if(k%20==19 && k!=0) {
				System.out.println();
			}
		}		
		
	}
}
