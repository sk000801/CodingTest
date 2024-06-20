import java.util.*;

// dp[1] = 1, dp[2] = 2, dp[3] = 4
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] dp = new int[12];

        dp[1] = 1;

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4; i <= 11; i++) {
            dp[i] = dp[i-3]+dp[i-2]+dp[i-1];
        }

        for(int i = 0; i < n; i++) {
            int num = in.nextInt();
            System.out.println(dp[num]);
        }
    }
}
