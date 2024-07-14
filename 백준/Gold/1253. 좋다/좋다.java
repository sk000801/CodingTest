import java.io.*;
import java.util.*;

// 처음에는 특정 인덱스의 범위(0, i보다 작은)로 탐색했으나
// 그냥 전체 인덱스의 범위를 탐색
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        int answer = 0;
        for(int i = 0; i < n; i++) {
            int temp = num[i];
            int idx = 0;
            int idx2 = n-1;
            while(idx < idx2) {
                if(idx == i) idx++;
                else if(idx2 == i) idx2--;
                if(idx >= idx2) break;

                int value = num[idx]+num[idx2];
                if(value > temp) idx2--;
                else if(value < temp) idx++;
                else {
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
