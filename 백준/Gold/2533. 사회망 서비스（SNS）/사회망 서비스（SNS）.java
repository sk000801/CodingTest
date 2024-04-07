import java.util.*;
import java.io.*;

// 트리에서의.. dp ....?
public class Main {
    static int n;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int[][] dp;

    // 0 = 얼리어답터, 1 = 일반인
    public static void search(int node) {
        visited[node] = true;
        dp[node][0] = 1;

        for(int i = 0; i < list.get(node).size(); i++) {
            int next = list.get(node).get(i);

            if(visited[next]) continue;

            search(next);

            dp[node][1] += dp[next][0]; //부모가 일반인이면 자식은 얼리어답터야함
            dp[node][0] += Math.min(dp[next][1], dp[next][0]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        dp = new int[n+1][2];
        
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < n-1; i++) {
            String[] s = br.readLine().split(" ");

            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            list.get(a).add(b);
            list.get(b).add(a);
        }

        search(1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
}
