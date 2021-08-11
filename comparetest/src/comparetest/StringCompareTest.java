package comparetest;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringCompareTest {
	public static void main(String[] args) {
		String[] word = {"boy", "Cat", "Lion", "dog", "elephant", "i", "dragon", "Any", "giraffe", "animal", "Dogcat", "girl"};
		List<String> list = Arrays.asList(word);
		System.out.println("1.List : " + list);
		Collections.sort(list);
		System.out.println("2.List(sort) : " + list); //string의 compareto는 사전순 정렬이 default
		
		//문자열 길이를 기준으로 오름차순 정렬 후 사전 순 정렬
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				int len1 = s1.length();
				int len2 = s2.length();
				if(len1 != len2) {
					return len1 - len2;
				}
				return s1.compareTo(s2);
			}
		});
		System.out.println("3.List(sort) : " + list); 
		
	}
}
