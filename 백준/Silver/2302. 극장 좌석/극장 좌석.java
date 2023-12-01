import java.util.*;

// n = 1 : 1
// n = 2 : 12 21
// n = 3 : 123 132 213
// 그냥 양 옆의 자리에 앉는 경우의 수 dp[n-1]+dp[n-2]
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        
        int m = in.nextInt();
        int num = 1;
        int idx = 0;
        for(int i = 0; i < m; i++) {
            int cur = in.nextInt();
            num *= dp[cur-idx-1];
            idx = cur;
        }
        num *= dp[n-idx];

        System.out.println(num);
    }
}
