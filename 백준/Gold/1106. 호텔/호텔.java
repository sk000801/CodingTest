import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] dp = new int[c+101];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken()); //비용
            int customer = Integer.parseInt(st.nextToken()); //인당
            
            for(int j = customer; j <= c+100; j++) {
                if(dp[j-customer] != Integer.MAX_VALUE) dp[j] = Math.min(dp[j], cost+dp[j-customer]);
            }
        }

        int res = Integer.MAX_VALUE;
        for(int i = c; i <= c+100; i++) {
            res = Math.min(dp[i], res);
        }

        System.out.println(res);
    }   
}
