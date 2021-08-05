package solution.programmers;

class Solution {
	public int solution(String s) {
		StringBuilder sb = new StringBuilder();
		int answer = 0;
		int slen = s.length();
		if(slen==1) return 1;
		int n = slen / 2;
		int min = 1001;
		
		for (int i = 1; i <= n; i++) {// 요약하는 글자수 배열
			int start = 0, count = 1, end = i;
			int num = slen%i;
			String check = "";
			while (true) {// 체크할 문자 정하는 반복문
				if (end > slen)
					break;
				check = s.substring(start, end);
				String next = "";
				while (true) {// 비교반복문
					start = start + i;
					end = end + i;
					if (end > slen)
						break;
					next = s.substring(start, end);
					if (check.equals(next)) {
						count++;
					} else {
						break;
					}
				}
				if (count == 1) {
					sb.append(check);
				} else {
					sb.append(count).append(check);
					count = 1;
				}
			}
			if(num!=0) {
				sb.append(s.substring(start,start+num));
			}
			answer = sb.toString().length();
			if (min > answer)
				min = answer;
			sb.setLength(0);
		}

		return min;
	}
}

public class level2_60057 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] s1 = new String[]{"a","aa","aabbaccc","ababcdcdababcdcd","abcabcdede","abcabcabcabcdededededede","xababcdcdababcdcd"};
		//7,9,8,14,17
		for(int i=0; i<s1.length; i++) {
			System.out.println("#" + i + " " + sol.solution(s1[i]));
		}

	}

}
