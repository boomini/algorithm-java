package solution.swexpert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class d4_1218 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new InputStreamReader(new FileInputStream("res/input_1218.txt")));
		String open = "([{<";
		String close = ")]}>";
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=10; t++) {
			sb.append("#").append(t).append(" ");
			int check = 1;
			Stack<Character> s1 = new Stack();
			int count = Integer.parseInt(in.readLine());
			String s= in.readLine();
			for(int i=0; i<count; i++) {
				char ck = s.charAt(i);
				//System.out.println(ck + "  " + s1.toString());
				if(open.contains(String.valueOf(ck))) s1.push(ck);
				
				else {
					if(s1.size()==0) {
						check=0;
						break;
					}
					if(open.indexOf(s1.peek())==close.indexOf(ck)) s1.pop();
					else {
						check=0;
						break;
					}
				}
				
			}
			if(!s1.empty()) check=0;
			sb.append(check).append("\n");
			
		}
		
		System.out.println(sb.toString());
		
	}
}
