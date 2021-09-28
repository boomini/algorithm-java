 package solution.swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class d4_5604 {
    private static long arr[];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc<=T;tc++) {        
            sb.append("#").append(tc).append(" ");
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            long M = Long.parseLong(st.nextToken());
            long N = Long.parseLong(st.nextToken());
            long k = 1;
            arr = new long[10];
            outer : while(true) {
                while(true) {               
                    if(M%10==0) {
                        break;
                    }
                    calc(M,k);
                    if(M==N) break outer;
                    M++;
                }
                 
                while(M<=N) {
                    if(N%10==9) {
                        break;
                    }
                     
                    calc(N,k);
                    if(M==N) break outer;
                    N--;
                }
                for(int i=0; i<=9; i++) {
                    arr[i]+=((N/10-M/10)+1)*k;
                }
                 
                N=N/10;
                M=M/10;
                k*=10;
                 
            }
            long sum = 0;
            for(int i=1; i<10; i++) {
                sum+=arr[i]*i;
            }
            System.out.println(Arrays.toString(arr));
            sb.append(sum).append("\n");
        }
        
        System.out.println(sb.toString());
    }
 
    private static void calc(long i, long k) {
        while(true) {
        arr[(int) (i%10)]+=k;
            i=i/10;
            if(i/10==0&&i%10==0) {
                break;
            }
        }
    }
}
