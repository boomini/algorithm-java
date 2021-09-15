import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class workshop_02 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int D[] = new int[n+1];
		D[1] = 2;
		D[2] = 5;
		for(int i=3; i<=n; i++) {
			if(i>=1)D[i]+= D[i-1]*2;
			if(i>=2)D[i]+= D[i-2];
		}
		System.out.println(D[n]);
	}
	/*
	 * 
	 */
}
