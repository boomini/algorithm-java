import java.util.Arrays;

public class BinarySearchTest {
	public static void main(String[] args) {
		int[] values = {3,11,15,20,21,45};
		System.out.println(Arrays.binarySearch(values, 3));
		System.out.println(Arrays.binarySearch(values, 45));
		System.out.println(Arrays.binarySearch(values, 11));
		System.out.println(Arrays.binarySearch(values, 30));
		System.out.println(Arrays.binarySearch(values, 1));
		System.out.println(Arrays.binarySearch(values, 50));
		
		System.out.println(Arrays.binarySearch(values, 1,4,45));
	}
}
