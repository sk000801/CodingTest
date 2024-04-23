import java.util.*;
import java.io.*;

public class Main {
    static int n, m, k;
    static int[][] value;
    static int[][] dp;

    public static class Point {
        int node;
        int score;

        public Point(int node, int score) {
            this.node = node;
            this.score = score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        value = new int[n+1][n+1];

        // dp[i][j]는 i개 지나 j번에 도착했을 경우의 최댓값
        dp = new int[m+1][n+1];
        for(int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a < b) {
                value[a][b] = Math.max(value[a][b], c);
            }
        }

        dp[1][1] = 0;

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                for(int r = 1; r < j; r++) {
                    if(value[j-r][j] == 0 || dp[i-1][j-r] == Integer.MIN_VALUE) continue;
                    
                    //i-1개의 도시를 거친 뒤 j-r -> j로 이동
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-r]+value[j-r][j]);
                }
            }
        }

        int max = 0;
        for(int i = 1; i <= m; i++) {
            max = Math.max(max, dp[i][n]);
        }

        System.out.println(max);
    }
}
