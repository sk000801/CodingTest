import java.io.*;
import java.util.*;

// 누적합 but 하나의 변수로 끝장내는
// 배열 길이는 n에 도달하면 종료가 되어 맨 끝 인덱스를 탐색하지 못함
// 초기값을 꼭 Integer.MAX_VALUE로 잡아줘야 함 ㅠㅠ
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] num = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MAX_VALUE;
        int start = 0;
        int fin = 0;
        int sum = 0;
        while(start <= n && fin <= n) {
            if(sum < s) {
                sum += num[fin++];
            } else {
                answer = Math.min(fin-start, answer);
                sum -= num[start++];
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }
}
