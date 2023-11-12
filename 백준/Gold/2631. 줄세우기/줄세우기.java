import java.util.*;

//LIS(최장 증가 부분 수열) 알고리즘
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] order = new int[n];
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) {
            order[i] = in.nextInt();
        }

        for(int i = 0; i < n; i++) {
            dp[i]++;
            for(int j = 0; j < i; j++) {
                if(order[j] < order[i]) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
        }
        
        int max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(dp[i], max);
        }

        System.out.println(n-max);
    }
}
