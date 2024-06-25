import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[][] dp = new int[10001][4];
        dp[1][1] = 1;
        dp[2][1] = 1; dp[2][2] = 1;
        dp[3][1] = 1; dp[3][2] = 1; dp[3][3] = 1;

        for(int i = 4; i <= 10000; i++) {
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1]+ dp[i-2][2];
            dp[i][3] = dp[i-3][1]+ dp[i-3][2]+ dp[i-3][3];
        }

        int t = in.nextInt();
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < t; i++) {
            int num = in.nextInt();
            sb.append(dp[num][1]+dp[num][2]+dp[num][3]).append("\n");
        }

        System.out.println(sb);
    }
}
