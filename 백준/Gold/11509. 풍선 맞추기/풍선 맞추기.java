import java.io.*;
import java.util.*;

// 어떻게 이런 생각을...
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 쏜 화살 수를 담는 배열
        int[] count = new int[1_000_001];

        // 차례대로 풍선을 탐색하면서
        for(int i = 0; i < n; i++) {
            int h = Integer.parseInt(st.nextToken());

            // 해당 높이에 화살이 이미 있다면 값 줄이기
            if(count[h] > 0) count[h]--;

            // 화살의 높이가 낮아지므로 낮아진 높이에 값 더해주기
            count[h-1]++;
        }

        int answer = 0;
        for(int i = 0; i < count.length; i++) {
            answer += count[i];
        }

        System.out.println(answer);
    }
}
