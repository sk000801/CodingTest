import java.util.*;

//똑같은 로직인 것 같은데 왜 주석은 안되는지 생각 좀 해보자
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuffer sb = new StringBuffer("");

        // int[] dp = new int[10001];
        // Arrays.fill(dp, 1);

        // for(int i = 2; i <= 10000; i++) {
        //     dp[i] += dp[i-2];
        //     if(i>=3) dp[i] += dp[i-3];
        // }

        int[][] dp = new int[10001][4];
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for(int i = 4; i <= 10000; i++) {
            dp[i][1] = 1;
            dp[i][2] = dp[i-2][2]+dp[i-2][1];
            dp[i][3] = dp[i-3][3]+dp[i-3][2]+dp[i-3][1];
        }

        int t = in.nextInt();
        for(int i = 0; i < t; i++) {
            int num = in.nextInt();
            sb.append((dp[num][1]+dp[num][2]+dp[num][3])+"\n");
        }

        System.out.println(sb);
    }
}
