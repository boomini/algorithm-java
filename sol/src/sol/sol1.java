package sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class sol1 {
	public static void main(String[] args) throws IOException {
		/*
		 * 프로그래밍 언어마다 변수를 표기하기 위한 특정한 표기법을 권장한다. 단어를 밑줄로 구분하는 스네이크표기법과, 
		 * 단어가 바뀔 때마다 대문자로 시작하는 카멜표기법이 대표적이다. 두가지 표기법으로 변환하는 프로그램을 구현하시오. 

			ex) this_is_long_variable_name 이 입력되면, thisIsLongVariableName 이라고 리턴하고, 
			thisIsLongVariableName 이 입력되면, this_is_long_variable_name 이라고 리턴한다.
			
			
			public String changeConvection(String input){
			    String result = "";
			}

		 */
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String s = in.readLine();
		
		StringTokenizer st = new StringTokenizer(s, "_");
		ArrayList<String> arr = new ArrayList<String>();
		while(st.hasMoreElements()) {
			arr.add(st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		if(arr.size()==1) {
			//카멜표기법인 경우
			char[] charray = s.toCharArray();
			
			for(int i=0; i<charray.length; i++) {
				if(charray[i]<97) {
					char c =(char) (charray[i]+32);
					sb.append("_").append(c);
					continue;
				}
				sb.append(charray[i]);
			}
		}else {
			//스테이크표기법
			for(int i=0; i<arr.size(); i++) {
				if(i==0) {
					sb.append(arr.get(i));
				}else {
					char[] charray=  arr.get(i).toCharArray();
					char c = (char)(charray[0] - 32);
					sb.append(c);
					for(int j=1; j<charray.length; j++) {
						sb.append(charray[j]);
					}
				}
			}
		}
		//'a' 97
		System.out.println(sb.toString());
	}
}
