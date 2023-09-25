import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] num = new int[n];
        for(int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }

        long[][] dp = new long[n][21];
        dp[0][num[0]] = 1;

        for(int i = 1; i < n-1; i++) {
            for(int j = 0; j <= 20; j++) {
                if(dp[i-1][j] != 0) {
                    if(j+num[i] >= 0 && j+num[i] <= 20) {
                        dp[i][j+num[i]] += dp[i-1][j];
                    } 
                    if(j-num[i] >= 0 && j-num[i] <= 20) {
                        dp[i][j-num[i]] += dp[i-1][j];
                    }
                }
            }
        }

        System.out.println(dp[n-2][num[n-1]]);
    }
}
