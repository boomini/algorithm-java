
public class IO5_StringBuillderTest {
	public static void main(String[] args) {
//      StringBuilder를 쓰면 문자열 이어붙이기 등의 처리를 할 때 매번 메모리에 올라가는 것을 방지해줌
      StringBuilder sb = new StringBuilder();
      sb.append("Hello ");
      sb.append("SAFFY!!");

//      !! 를 빼는 방법, 보통 반복문을 돌리고 마지막 반복일 때는 다르게 출력하고 싶을 경우 유용
      sb.setLength(sb.length() - 2);
      System.out.println(sb.toString());
   }
}
