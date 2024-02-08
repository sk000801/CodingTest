import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] water = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < water.length; i++) {
            water[i] = Integer.parseInt(st.nextToken());
        }

        int val = 2_000_000_001;

        int[] ans = new int[2];

        int start = 0;
        int end = n-1;
        while(start < end) {
            int res = water[start]+water[end];

            //여기 절댓값 설정에서 헤맸네 이런
            if(Math.abs(res) < val) {
                ans = new int[]{water[start], water[end]};
                val = Math.abs(res);
            }

            if(res > 0) end--;
            else if(res < 0) start++;
            else break;
        }

        System.out.println(ans[0]+" "+ans[1]);
    }
}
