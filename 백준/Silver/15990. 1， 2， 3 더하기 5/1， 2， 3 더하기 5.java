import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //2차원 배열을 통해 점화식을 구함(마지막 숫자 체크)
        long[][] dp = new long[100_001][4];

        dp[1][1] = 1;

        dp[2][2] = 1; 

        dp[3][1] = 1; dp[3][2] = 1; dp[3][3] = 1;

        long num = 1_000_000_009;

        for(int i = 4; i <= 100_000; i++) {
            dp[i][1] = (dp[i-1][2]+dp[i-1][3])%num;
            dp[i][2] = (dp[i-2][1]+dp[i-2][3])%num;
            dp[i][3] = (dp[i-3][1]+dp[i-3][2])%num;
        }

        int n = in.nextInt();
        for(int i = 0; i < n; i++) {
            int val = in.nextInt();
            long ans = (dp[val][1]+dp[val][2]+dp[val][3])%num;
            System.out.println(ans);
        }
    }
}
