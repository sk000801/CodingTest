import java.util.*;

// 카드 i개 + 카드 n-i개
// dp[n] = dp[i]+dp[n-i]
// 기본값은 n개가 담긴 카드 팩의 가격
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] num = new int[n+1];
        int[] dp = new int[n+1];
        for(int i = 1; i <= n; i++) {
            num[i] = in.nextInt();
        }

        for(int i = 1; i <= n; i++) {
            dp[i] = num[i];
            for(int j = 1; j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i-j]+num[j]);
            }
        }

        System.out.println(dp[n]);
    }
}
