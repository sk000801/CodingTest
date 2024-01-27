import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] num = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        int start = 0;
        int fin = n-1;
        int min = Integer.MAX_VALUE;
        int[] ans = new int[2];

        while(start < fin) {
            int mid = (num[start]+num[fin]);

            if(Math.abs(mid) < min) {
                min = Math.abs(mid);
                ans = new int[]{num[start], num[fin]};
            } 

            if(min == 0) break;
            
            if(mid > 0) {
                fin--;
            }
            else {
                start++;
            }
        }

        System.out.println(ans[0]+" "+ans[1]);
    }
}
