import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] cost = new int[n];
        long sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            sum += cost[i];
        }
        
        Arrays.sort(cost);

        int limit = Integer.parseInt(br.readLine());
        if(sum <= limit) {
            System.out.println(cost[n-1]);
            return;
        }

        int start = 0;
        int fin = cost[n-1];
        int ans = 0;

        while(start <= fin) {
            int mid = (start+fin)/2;

            long temp = 0;
            for(int i = 0; i < n; i++) {
                if(mid < cost[i]) temp += mid;
                else temp += cost[i];
            }

            if(temp <= limit) {
                start = mid+1;
                ans = Math.max(ans, mid);
            } else fin = mid-1;
        }

        System.out.println(ans);
    }
}
