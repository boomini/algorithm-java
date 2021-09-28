import java.util.Arrays;

public class EuclidDivide {

	   public static void main(String[] args) {

	      euclid(1071, 1029);
	      System.out.println(Arrays.toString(exgcd(120, 150)));
	      long[] mm = exgcd(1071, 1029);
	      System.out.printf("(%d)*(%d)+(%d)*(%d)=%d\n", 1071, mm[1], 1029, mm[2], mm[0]);
	      System.out.println(gcd(1071, 1029));
	   }

	   private static int gcd(int a, int b) {
	      if (a == 0)
	         return b;
	      else if (b == 0)
	         return a;
	      else if (a > b)
	         return gcd(a % b, b);
	      else if (a < b)
	         return gcd(a, b % a);
	      else
	         return a;
	   }

	   private static long[] exgcd(int a, int b) {
	      if (b == 0)
	         return new long[] { a, 1, 0 };
	      else {
	         long[] coef = exgcd(b, a % b);
	         long temp = coef[1] - coef[2] * (a / b);
	         coef[1] = coef[2];
	         coef[2] = temp;
	         return coef;
	      }
	   }

	   private static void euclid(int a, int b) {
	      int r0 = a, r1 = b;
	      int s0 = 1, s1 = 0;
	      int t0 = 0, t1 = 1;
	      int temp = 0;
	      int q = 0;

	      while (r1 > 0) {
	         q = r0 / r1;

	         temp = r0;
	         r0 = r1;
	         r1 = temp - r1 * q; // 42 = 1071 - 1029 * (1071 / 2019)

	         temp = s0;
	         s0 = s1;
	         s1 = temp - s1 * q;

	         temp = t0;
	         t0 = t1;
	         t1 = temp - t1 * q;
	      }

	      System.out.printf("(%d)*(%d)+(%d)*(%d)=%d\n", a, s0, b, t0, a * s0 + b * t0);
	   }

}
