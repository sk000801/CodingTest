import java.util.*;
import java.io.*;

// 오 dp만 있으면 금방 푼다!
public class Main {
    static int n, m;
    static int[] order = new int[1001];
    static boolean[][] visited = new boolean[1001][1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            visited[a][b] = true; //a가 선수과목
        }

        for(int i = 1; i <= n; i++) {
            order[i] = 1;

            for(int j = 1; j < i; j++) {
                if(visited[j][i]) {
                    order[i] = Math.max(order[i], order[j]+1);
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int i = 1; i <= n; i++) {
            sb.append(order[i]).append(" ");
        }

        System.out.println(sb);
    }
}