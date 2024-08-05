import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] dp;
    static int[] num;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        num = new int[n];
        dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, -1);

        dp[0] = num[0];
        answer = num[0];

        for(int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1]+num[i], num[i]);

            answer = Math.max(dp[i], answer);
        }

        System.out.println(answer);
    }
}
