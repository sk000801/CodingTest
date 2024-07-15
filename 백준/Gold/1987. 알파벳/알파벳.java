import java.io.*;
import java.util.*;

// dfs로 풀어야돼
public class Main {
    static int r, c;
    static char[][] alpha;
    static boolean[] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int ans = Integer.MIN_VALUE;

    public static void dfs(int x, int y, int count) {
        visited[alpha[x][y]-'A'] = true;
        ans = Math.max(ans, count);

        for(int i = 0; i < 4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx<0||ny<0||nx>=r||ny>=c) continue;
            if(!visited[alpha[nx][ny]-'A']) {
                dfs(nx, ny, count+1);
                visited[alpha[nx][ny]-'A'] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        alpha = new char[r][c];
        visited = new boolean[26];

        for(int i = 0; i < r; i++) {
            String s = br.readLine();
            for(int j = 0; j < c; j++) {
                alpha[i][j] = s.charAt(j);
            }
        }

        dfs(0, 0, 1);

        System.out.println(ans);
    }
}
