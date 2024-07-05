import java.io.*;
import java.util.*;

// 이분탐색밖에 방법이 없나
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        int start = 0;
        int end = n-1;

        int min = Integer.MAX_VALUE;
        int[] ans = new int[2];
        while(start < end) {
            int val = num[start]+num[end];

            if(Math.abs(val) < min) {
                min = Math.abs(val);
                ans[0] = num[start];
                ans[1] = num[end];
            }

            if(val > 0) end--;
            else if(val < 0) start++;
            else break;
        }

        Arrays.sort(ans);
        
        System.out.println(ans[0]+" "+ans[1]);
    }
}
