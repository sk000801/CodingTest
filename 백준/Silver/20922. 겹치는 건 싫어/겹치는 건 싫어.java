import java.io.*;
import java.util.*;

// 투 포인터 개념
// 내 풀이 참고
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] num = new int[n];
        int[] count = new int[100_001];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int fin = 0;
        int answer = 0;
        while(fin < n) {
            while(fin < n && count[num[fin]]+1 <= k) {
                count[num[fin]]++;
                fin++;
            }

            answer = Math.max(answer, fin-start);
            count[num[start]]--;
            start++;
        }

        System.out.println(answer);
    }
}