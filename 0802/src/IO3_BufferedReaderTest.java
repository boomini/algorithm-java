import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 4
// 1 2 3 5
public class IO3_BufferedReaderTest {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		String str = in.readLine();
//		char ch[] = str.toCharArray();
//		for(char c : ch) {
//			System.out.println(c);
//		}
		
		int n = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		while(n-->0){
			int value = Integer.parseInt(st.nextToken());
			System.out.println(value);
		}
	}
}
