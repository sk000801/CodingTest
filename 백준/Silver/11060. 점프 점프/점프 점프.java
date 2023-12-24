import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        long[] dp = new long[n+1];
        int[] move = new int[n+1];

        for(int i = 1; i <= n; i++) {
            move[i] = in.nextInt();
        }

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        for(int i = 1; i <= n; i++) {
            if(dp[i] >= Integer.MAX_VALUE) continue;
            for(int j = 1; j <= move[i]; j++) {
                if(i+j > n) continue;
                dp[i+j] = Math.min(dp[i+j], dp[i]+1);
            }
        }

        System.out.println(dp[n] >= Integer.MAX_VALUE ? -1 : dp[n]);
    }
}
