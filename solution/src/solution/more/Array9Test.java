package solution.more;

import java.util.Arrays;

public class Array9Test {

	    public static void main(String[] args) {
	        int[] di={-1,0,1,0};//»ó¿ìÇÏÁÂ
	        int[] dj={0,1,0,-1};
	        int[][] a={
	            {0,0,0,0,0,0,0,0,0},
	            {0,0,0,0,0,0,0,0,0},
	            {0,0,0,0,0,0,0,0,0},
	            {0,0,0,0,0,0,0,0,0},
	            {0,0,0,0,9,0,0,0,0},
	            {0,0,0,0,0,0,0,0,0},
	            {0,0,0,0,0,0,0,0,0},
	            {0,0,0,0,0,0,0,0,0},
	            {0,0,0,0,0,0,0,0,0}
	        };
	        int N=a.length;
	        int M=a[0].length;
	        for(int i=0; i<N; i++) {
	            for(int j=0; j<M; j++) {
	                if(a[i][j]==9) {
	                    for(int d=0; d<4; d++) {
	                        for(int k=1; k<=3; k++) {
	                            int ni=i+di[d]*k;
	                            int nj=j+dj[d]*k;
	                            if(0<=ni&&ni<N && 0<=nj&&nj<M) {
	                                a[ni][nj]=k;
	                            }
	                        }
	                    }
	                }
	            }
	        }
	        for(int[] b:a) System.out.println(Arrays.toString(b));
	    }
	}

