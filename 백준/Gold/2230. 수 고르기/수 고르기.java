import java.io.*;
import java.util.*;

// 수열 안에서 두 수를 골랐을 때 그 차이가 m 이상이면서 가장 작은 경우
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] num = new int[n];
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(num);

        int min = Integer.MAX_VALUE;

        int start = 0;
        int end = 0;
        while(end < n) {
            int value = num[end]-num[start];

            if(value < m) {
                end++;
                continue;
            } 

            if(value == m) {
                min = m;
                break;
            }

            min = Math.min(min, value);
            start++;
        }

        System.out.println(min);
    }
}
