import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long[] dp = new long[1_000_001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4; i <= 1_000_000; i++) {
            dp[i] = (dp[i-1]+dp[i-2]+dp[i-3])%1_000_000_009;
        }

        int t = in.nextInt();
        for(int i = 0; i < t; i++) {
            int n = in.nextInt();
            System.out.println(dp[n]);
        }
    }
}
