import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] num = new int[n][3];
        int[][] dp = new int[n][3];

        // 순서대로 빨강, 초록, 파랑
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = num[0][0];
        dp[0][1] = num[0][1];
        dp[0][2] = num[0][2];
        for(int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2])+num[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2])+num[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1])+num[i][2];
        }

        int min = Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
        System.out.println(min);
    }
}
