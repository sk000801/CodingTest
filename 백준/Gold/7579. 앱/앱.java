import java.util.*;
import java.io.*;

//봐도봐도 익숙하지 않은 냅색 풀이를 곁들인....
public class Main {
    static int n, m;
    static int[] num;
    static int[] plus;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = new int[n+1];
        plus = new int[n+1];
        dp = new int[n+1][100_001]; //확보할 수 있는 메모리 크기

        st  = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            plus[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) { //앱 인덱스
            for(int j = 0; j <= 100_000; j++) { //비용
                if(i == 1) {
                    if(j >= plus[i]) dp[i][j] = num[i];
                } else {
                    if(j >= plus[i]) {
                        dp[i][j] = Math.max(dp[i-1][j-plus[i]]+num[i], dp[i-1][j]);
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                }

                if(dp[i][j] >= m) answer = Math.min(answer, j);
            }
        }

        System.out.println(answer);
    }
} 
