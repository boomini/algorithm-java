package comparetest;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class test {
	public static void main(String[] args) {
		Integer[] attack = {8,9,2,5,4,7};
		Integer[] attack2 = {16,19,15};
		Set<Integer> set = new HashSet<Integer>(Arrays.asList(attack2));//같은곳 공격 지우기
		attack2 = set.toArray(attack2);
		Collections.reverse(Arrays.asList(attack2));
		System.out.println(Arrays.toString(attack2));
	}
}
