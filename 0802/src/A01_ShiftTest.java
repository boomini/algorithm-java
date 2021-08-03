import java.util.Arrays;

public class A01_ShiftTest {
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5};
		
		System.out.println(Arrays.toString(arr));
		rightShift(arr);
		leftShift(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	private static void leftShift(int [] arr) {
		int temp = arr[0];
		for(int i=0; i<arr.length-1; i++) {
			arr[i] = arr[i+1];
		}
		arr[arr.length-1] = temp;
	}
	private static void rightShift(int [] arr) {
		int temp = arr[arr.length - 1];
		for(int i=arr.length-1; i>0; i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = temp;
	}

	//따로 리턴해주지 않는이유는 배열을 넘겨줄때 primitive type이면 값 자체를 넘겨주고 reference type이면 참조값을 넘겨주기때문에 함수에서 변경해주면 main에서 가르키는 arr도 똑같은 곳을 바라보고 있기 때문에 값이 변경되어 있다.
	
}
