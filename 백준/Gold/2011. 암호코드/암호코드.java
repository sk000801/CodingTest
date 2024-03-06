import java.util.*;

// A=1, Z=26
// dfs로 풀려고 했는데...
public class Main {
    static int[] dp;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        dp = new int[s.length()+1];
        dp[0] = 1;

        for(int i = 1; i <= s.length(); i++) {
            int num = Character.getNumericValue(s.charAt(i-1));
            if(num >=1 && num <= 9) {
                dp[i] += dp[i-1];
                dp[i] %= 1_000_000;
            }

            if(i == 1) continue;

            int num2 = Character.getNumericValue(s.charAt(i-2));

            if(num2 == 0) continue;
            
            int val = num2*10+num;
            if(val >= 10 && val <= 26) {
                dp[i] += dp[i-2];
                dp[i] %= 1_000_000;
            }
        }

        System.out.println(dp[s.length()]);
    }
}