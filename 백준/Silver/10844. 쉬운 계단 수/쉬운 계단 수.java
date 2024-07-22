import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        long[][] dp = new long[n+1][10];
        // 길이가 i이며 j로 시작하는 수

        for(int i = 0; i <= 9; i++) {
            // 길이가 1이며 i로 시작하는 수는 당연히 i 본인
            dp[1][i] = 1;
        }

        for(int i = 2; i <= n; i++) {
            // 0으로 시작하는 수  = i-1수
            dp[i][0] = dp[i-1][1];

            for(int j = 1; j <= 8; j++) {
                dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1])% 1_000_000_000;
                dp[i][j] %= 1_000_000_000;
            }

            // 9로 시작하는 계단 수  = 8로 시작하는 계단 수
            dp[i][9] = dp[i-1][8];
        }

        long answer = 0;
        for(int i = 1; i <= 9; i++) {
            answer += dp[n][i];
            answer %= 1_000_000_000;
        }

        System.out.println(answer);
    }
}
