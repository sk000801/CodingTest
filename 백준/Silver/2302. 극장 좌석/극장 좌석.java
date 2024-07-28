import java.io.*;

// VIP의 고정 좌석을 고려하지 않으면, 이는 피보나치 수열
// 피보나치 수열에서 vip 자리 제외 나머지 좌석 경우의 수 곱
// 이건 못 풀어...ㅠㅠ
public class Main {
    static int n, m;
    static int[] dp;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dp = new int[41];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= 40; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }

        int answer = 1;

        int cur = 0;
        for(int i = 0; i < m; i++) {
            int vip = Integer.parseInt(br.readLine());
            answer *= dp[vip-cur-1];
            cur = vip;
        }
        // 마지막 VIP ~ 끝
        answer *= dp[n-cur];

        // cur => 0 -> 2 -> 4 -> 7

        System.out.println(answer);
    }
}
