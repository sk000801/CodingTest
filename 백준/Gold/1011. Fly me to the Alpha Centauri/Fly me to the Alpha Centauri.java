import java.util.*;
import java.io.*;

// k광년 이동 -> k-1, k, k+1 광년만을 이동할 수 있음
// 최소한의 작동횟수로 목적지까지 이동
// 내가 생각했던 재귀 풀이가 아니라 어떤 규칙을 찾아야 하는것 같다,,
// -> 그냥 목적지까지 가는게 아니라 서서히 거리를 줄여 직전에 1만큼만 이동해야 해서
// (y-x) 거리 기준 1, 4, 9, 16, 25 최댓값이 변함
// 그 다음이 count가 변하는 시점

// distance
// 1 2 3 4 5 6 7 8 9 10
// count
// 1 2 3 3 4 4 5 5 5 6
// max
// 1 1 1 2 2 2 2 2 3 3

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 거리의 제곱근에서 정수 부분만 가져감
            int max = (int) Math.sqrt(y-x);

            // 거리의 제곱근이 딱 정수라면
            if(max == Math.sqrt(y-x)) sb.append(max*2-1);
            // max*max < y-x <= max*max+max
            // distance가 제곱수인 값 사이의 구간에 묶인 개수는 max 값과 같다
            else if(y-x <= max*max+max) sb.append(max*2);
            else sb.append(max*2+1);

            if(i < n-1) sb.append("\n");
        }

        System.out.println(sb);
    }
}
