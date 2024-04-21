import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        long[][] dp = new long[n+1][m+1];
        
        int[][] garo = new int[n][m+1];
        int[][] sero = new int[n+1][m];

        int k = in.nextInt();
        // 오 이렇게 시작 영역에 표시해놓는거 좋은 것 같다
        for(int i = 0; i < k; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int d = in.nextInt();

            if(b == d) garo[Math.min(a, c)][b] = 1; //y값 같을 때
            else sero[a][Math.min(b, d)] = 1; //x값 같을때
        }

        for(int i = 1; i <= n; i++) {
            if(garo[i-1][0] == 1) break;
            dp[i][0] = 1; 
        }

        for(int i = 1; i <= m; i++) {
            if(sero[0][i-1] == 1) break;
            dp[0][i] = 1;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                dp[i][j] = dp[i][j-1]+dp[i-1][j];

                if(garo[i-1][j] == 1) dp[i][j] -= dp[i-1][j];
                if(sero[i][j-1] == 1) dp[i][j] -= dp[i][j-1];
            }
        }

        System.out.println(dp[n][m]);
    }
}
