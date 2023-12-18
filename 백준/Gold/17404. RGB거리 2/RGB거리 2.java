import java.util.*;

//빨강 초록 파랑
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[][] val = new int[n+1][4];
        int[][] dp = new int[n+1][4];

        int ans  = 1000_000;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= 3; j++) {
                val[i][j] = in.nextInt();
            }
        }

        for(int j = 1; j <= 3; j++) { //첫번째 집 색 고정

            for(int r = 1; r <= 3; r++) {
                if(j == r) { //첫번째 집 색으로 고정
                    dp[1][r] = val[1][r]; 
                } else {
                    dp[1][r] = 100_000;
                }
            }

            for(int i = 2; i <= n; i++) { //이전 RGB 로직과 동일
                dp[i][1] = Math.min(dp[i-1][2], dp[i-1][3])+val[i][1];
                dp[i][2] = Math.min(dp[i-1][1], dp[i-1][3])+val[i][2];
                dp[i][3] = Math.min(dp[i-1][1], dp[i-1][2])+val[i][3];
            }

            for(int i = 1; i <= 3; i++) {
                if(i != j) { //첫번째 집과 같은 색깔이 아닐 때
                    ans = Math.min(ans, dp[n][i]);
                }
            }
        }

        System.out.println(ans);
    }
}
