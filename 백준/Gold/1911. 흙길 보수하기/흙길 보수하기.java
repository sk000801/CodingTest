import java.util.*;
import java.io.*;

// 스위핑 알고리즘 -> 처음~끝까지 한번만 훑는것
// 주어진 값들 어떤 조건으로 정렬시켜놓고 탐색해야 함
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[][] water = new int[n][2];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            water[i] = new int[]{a, b};
        }

        Arrays.sort(water, (a, b) -> {
            if(a[0] == b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });

        int answer = 0;
        int value = 0;
        for(int i = 0; i < water.length; i++) {
            // 기준점보다 시작값이 크면 갱신
            if(water[i][0] > value) {
                value = water[i][0];
            }

            // 기준점보다 끝값이 크면 정답++
            // 널빤지를 깔고 기준점을 널빤지 길이만큼 늘림
            if(water[i][1] > value) {
                while(water[i][1] > value) {
                    value += l;
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
