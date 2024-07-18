import java.io.*;
import java.util.*;

//이게맞나
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        long answer = 0;
        int[] count = new int[100_001];

        int start = 0;
        int end = 0;
        while(start < n) {
            while(end < n && count[num[end]] == 0) {
                count[num[end++]]++;
            }

            // 현재 시작값 기준 모든 경우 구하기
            answer += (end-start);
            count[num[start++]]--;
        }

        System.out.println(answer);
    }
}
