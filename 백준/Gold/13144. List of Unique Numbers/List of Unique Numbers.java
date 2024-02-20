import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        int[] count = new int[100_001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            num[i] = value;
        }

        long answer = 0;

        int start = 0;
        int end = 0;

        while(start < n) {
            while(end < n && count[num[end]] == 0) {
                count[num[end++]]++;
            }

            answer += (end-start);

            count[num[start++]]--;
        }

        System.out.println(answer);
    }
}
