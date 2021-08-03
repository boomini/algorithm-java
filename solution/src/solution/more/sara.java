package solution.more;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sara  {

   public static void switchOnOff() throws NumberFormatException, IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int sNum = Integer.parseInt(in.readLine());
      String swiches = in.readLine();
      String[] s = swiches.split(" ");
      int stNum = Integer.parseInt(in.readLine());

      for (int i = 0; i < stNum; i++) {
         String test = in.readLine();
         char[] t = test.toCharArray();
         int g = Character.getNumericValue(t[0]);
         int num = Character.getNumericValue(t[2]);
         int j = num - 1;
         if (g == 1) {
            // 巢切积老 版快
            while (j < s.length) {
               if (s[j].equals("1"))
                  s[j] = "0";
               else
                  s[j] = "1";
               j = j + num;
            }
         } else {
            // 咯切积老 版快
            if (s[j].equals("1"))
               s[j] = "0";
            else
               s[j] = "1";

            int r = 1;
            while (true) {
               if (j - r < 0 || j + r >= s.length || !(s[j - r].equals(s[j + r])))
                  break;
               if (s[j - r].equals("1")) {
                  s[j - r] = "0";
                  s[j + r] = "0";
               } else {
                  s[j - r] = "1";
                  s[j + r] = "1";
               }
               r++;
            }

         }
         for (int k = 0; k < s.length; k++) {
             System.out.print(s[k] + " ");
             if (k != 0 && k % 20 == 19)
                System.out.println();
          }
         System.out.println();
      }
      
   }

   public static void main(String[] args) {
      try {
         switchOnOff();
      } catch (NumberFormatException | IOException e) {
         e.printStackTrace();
      }
   }
}