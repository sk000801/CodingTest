import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[][] val = new int[n][2];
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            val[i][0] = in.nextInt();
            val[i][1] = in.nextInt();
        }

        //dp[a][b]가 a~b까지의 행렬 곱 연산 최솟값
        for(int i = 1; i < n; i++) {
            for(int j = 0; i+j < n; j++) {
                dp[j][i+j] = Integer.MAX_VALUE;
                for(int r = j; r < i+j; r++) {
                    dp[j][i+j] = Math.min(dp[j][i+j], dp[j][r]+dp[r+1][i+j]+val[j][0]*val[r][1]*val[i+j][1]);
                }
            }
        }

        System.out.println(dp[0][n-1]);
    }
}
