import java.util.*;

public class Main {
    static int[] dp = new int[100_001];
    static int n, k;

    public static void search(int num) {
        boolean[] visited = new boolean[100_001];
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        
        while(!q.isEmpty()) {
            int cur = q.poll();

            if(cur == k) return;

            for(int i = 0; i < 3; i++) {
                int next = 0;

                if(i == 0) next = cur*2;
                else if(i == 1) next = cur-1;
                else next = cur+1;

                if(next >= 0 && next <= 100_000 && dp[next] == Integer.MAX_VALUE) {
                    if(i != 0) dp[next] = dp[cur]+1;
                    else dp[next] = dp[cur];

                    q.add(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        k = in.nextInt();

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;

        search(n);

        System.out.println(dp[k]);
    }
}
