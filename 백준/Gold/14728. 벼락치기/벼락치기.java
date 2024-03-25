import java.util.*;
import java.io.*;

// 얻을 수 있는 최대 점수
// 배낭 알고리즘
public class Main {
    static int n, t;
    static int[][] chapter;
    static int[][] dp = new int[101][10001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        
        chapter = new int[n+1][2];
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            chapter[i][0] = Integer.parseInt(st.nextToken());
            chapter[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= t; j++) {
                if(chapter[i][0] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j],chapter[i][1]+dp[i-1][j-chapter[i][0]]);
                }
                else dp[i][j] = dp[i-1][j];
            }
        }

        System.out.println(dp[n][t]);
    }
}
