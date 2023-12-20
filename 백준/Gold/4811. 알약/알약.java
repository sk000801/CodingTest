import java.util.*;

//찾아보니 카탈린 수? 라고 하더라
//합이 n-1인 요소들 찾는 것 까진 파악했으나 fail..
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        StringBuffer sb = new StringBuffer("");

        long[] dp = new long[31];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= 30; i++) {
            for(int j = 0; j < i; j++) {
                dp[i] += dp[j]*dp[i-1-j];
            }
        }

        while(true) {
            int n = in.nextInt();
            if(n == 0) break;

            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
