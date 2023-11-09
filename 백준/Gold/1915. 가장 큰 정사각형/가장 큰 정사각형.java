import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int answer = 0;

        String[] s = in.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[][] map = new int[n+1][m+1];
        int[][] dp = new int[n+1][m+1];

        for(int i = 1; i <= n; i++) {
            s = in.nextLine().split("");
            for(int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(s[j-1]);
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(map[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }

        System.out.println(answer*answer);
    }
}
