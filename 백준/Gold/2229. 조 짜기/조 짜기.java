import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        int[] score = new int[n+1];
        // 해당 인덱스의 학생까지 포함했을 경우에 조가 잘 짜인 경우 최댓값
        int[] dp = new int[n+1];

        StringTokenizer st = new StringTokenizer(in.nextLine());
        for(int i = 1; i <= n; i++) {
            score[i] = Integer.parseInt(st.nextToken());

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for(int j = i; j > 0; j--) {
                max = Math.max(max, score[j]);
                min = Math.min(min, score[j]);

                dp[i] = Math.max(dp[i], max-min+dp[j-1]);
            }
        }

        System.out.println(dp[n]);
    }
}
