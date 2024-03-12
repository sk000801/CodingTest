import java.util.*;
import java.io.*;

// T로 표시된 부분이 가지 못하는 부분
// 한수가 집까지 도착하는 경우의 수 중 거리가 K인 가짓수를 구하는 것!
public class Main {
    static String[][] road;
    static int r,c,k;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static boolean[][] visited;
    static int answer = 0;

    public static class Point {
        int x;
        int y;
        int count = 0;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void dfs(int x, int y, int count) {
        if(x == 0 && y == c-1) {
            if(count == k) answer++;
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx<0||nx>=r||ny<0||ny>=c) continue;
            if(!visited[nx][ny] && !road[nx][ny].equals("T")) {
                visited[nx][ny] = true;
                dfs(nx, ny, count+1);
                visited[nx][ny] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        road = new String[r][c];
        visited = new boolean[r][c];

        for(int i = 0; i < r; i++) {
            String[] s = br.readLine().split("");
            for(int j = 0; j < c; j++) {
                road[i][j] = s[j];
            }
        }

        visited[r-1][0] = true;
        dfs(r-1, 0, 1);

        System.out.println(answer);
    }
}
