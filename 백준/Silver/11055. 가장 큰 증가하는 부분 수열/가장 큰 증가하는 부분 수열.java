import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] num = new int[n+1];
        int[] dp = new int[n+1];

        for(int i = 1; i <= n; i++) {
            num[i] = in.nextInt();
            dp[i] = num[i];
        }

        // 값이 하나일 수도 있는 경우를 고려해야 함
        int max = num[1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j < i; j++) {
                if(num[j] < num[i]) {
                    dp[i] = Math.max(dp[j]+num[i], dp[i]);
                    max = Math.max(dp[i], max);
                }
            }
        }

        System.out.println(max);
    }
}
