import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] num = new int[n];
        int[] dp = new int[n+1];
        for(int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }

        for(int i = 1; i <= n; i++) {
            dp[i] = 1;
            for(int j = 1; j < i; j++) {
                if(num[j-1] < num[i-1]) dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }

        int max = 0;
        for(int i = 1; i <= n; i++) {
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }
}
