import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] num = new int[n];
        for(int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }

        //여기서 0일때는 제거 하지 않은 경우, 1일때는 제거한 경우
        long[][] dp = new long[n][2];
        dp[0][0] = dp[0][1] = num[0];

        long ans = Integer.MIN_VALUE;
        for(int i = 1; i < n; i++) {
            //제거하지 않았으니 단순히 더했을 때와 값을 비교
            dp[i][0] = Math.max(dp[i-1][0]+num[i], num[i]);
            //제거했으므로 이전 최대 연속 합에 현재 값 더함
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]+num[i]);
            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }
        ans = Math.max(dp[0][0], ans);

        System.out.println(ans);
    }
}
