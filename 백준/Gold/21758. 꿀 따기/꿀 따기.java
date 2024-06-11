import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] honey = new int[n];
        long[] left = new long[n];
        long[] right = new long[n];
        long total = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            honey[i] = Integer.parseInt(st.nextToken());

            total += honey[i];
            right[i] = total;
        }

        total = 0;
        for(int i = n-1; i >= 0; i--) {
            total += honey[i];

            left[i] = total;
        }

        long count = 0;
        long val1 = 0;
        long val2 = 0;

        // 벌 위치 앞쪽 자리 고정
        for(int i = 1; i <= n-2; i++) {
            val1 = total-honey[i]-honey[0];
            val2 = total-right[i];

            count = Math.max(val1+val2, count);
        }

         // 벌 위치 뒤쪽 자리 고정
        for(int i = n-2; i >= 1; i--) {
            val1 = total-honey[n-1]-honey[i];
            val2 = total-left[i];

            count = Math.max(count, val1+val2);
        }

        // 벌 자리 양쪽 고정        
        for(int i = 1; i <= n-2; i++) {
            val1 = right[i]-honey[0];
            val2 = left[i]-honey[n-1];

            count = Math.max(count, val1+val2);
        }

        System.out.println(count);
    }
} 
