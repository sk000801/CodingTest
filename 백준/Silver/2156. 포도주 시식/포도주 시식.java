import java.io.*;

public class Main {
    static int[] num;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        num = new int[n+1];
        dp = new int[n+1];

        for(int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = num[1];
        // 왜 어떤 경우에도 두 가지를 모두 더하는 것이 최댓값 ㅠㅠ
        if(n >= 2) dp[2] = num[1]+num[2];

        for(int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2], dp[i-3]+num[i-1])+num[i]);
        }

        System.out.println(dp[n]);
    }
}
