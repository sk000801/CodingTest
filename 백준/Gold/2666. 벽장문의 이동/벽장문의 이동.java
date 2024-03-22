import java.util.*;
import java.io.*;

// 입력으로 주어지는 벽장의 순서에 따라 벽장문을 이동하는 순서를 찾는 것
// 이런 점화식은 어떻게 떠올릴 수 있는 걸까,,, 모르겠다
public class Main {
    static int n, m;
    static int[] first = new int[2];
    static int[] order;
    static int[][][] dp;

    public static int dfs(int idx, int left, int right) {
        if(idx == m) return 0;

        // 앞부분 열려있는 벽장과 열려고 하는 벽장 차의 절댓값
        // 둘 중 가까운 곳을 선택한 뒤 재귀호출
        if(dp[idx][left][right] == Integer.MIN_VALUE) {
            int val1 = Math.abs(left-order[idx]);
            int val2 = Math.abs(right-order[idx]);
            
            dp[idx][left][right] = Math.min(val1+dfs(idx+1, order[idx], right), val2+dfs(idx+1, left, order[idx]));
        }

        return dp[idx][left][right];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        first[0] = Integer.parseInt(st.nextToken());
        first[1] = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        dp = new int[m][n+1][n+1];

        order = new int[m];
        for(int i = 0; i < m; i++) {
            order[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < m; i++) {
            for(int j = 1; j <= n; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }

        System.out.println(dfs(0, first[0], first[1]));
    }
}
