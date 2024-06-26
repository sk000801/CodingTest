import java.util.*;

public class Main {
    static int n, k;
    static int[] dp;

    public static void dfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        dp[n] = 0;

        while(!q.isEmpty()) {
            int cur = q.poll();

            if(cur == k) return;

            int next = 0;

            for(int i = 0; i < 3; i++) {
                if(i == 0) next = cur*2;
                else if(i == 1) next = cur-1;
                else next = cur+1;

                if(next >= 0 && next <= 100_000 && dp[next] == Integer.MAX_VALUE) {
                    if(i == 0) dp[next] = dp[cur];
                    else dp[next] = dp[cur]+1;

                    q.add(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        k = in.nextInt();
        dp = new int[100_001];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dfs();

        System.out.println(dp[k]);
    }
}
