import java.io.*;
import java.util.*;

// 각 구간마다의 일정 갯수만 세어주면 됨
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] visited = new int[366];

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int fin = Integer.parseInt(st.nextToken());

            for(int j = start; j <= fin; j++) {
                visited[j]++;
            }
        }

        int answer = 0;
        int max = 0;
        int count = 0;
        for(int i = 0; i <= 365; i++) {
            if(visited[i] > 0) {
                count++;
                max = Math.max(max, visited[i]);
            } else {
                answer += count*max;
                count = 0;
                max = 0;
            }
        }

        answer += max*count;

        System.out.println(answer);
    }
}
