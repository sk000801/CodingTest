import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int[][] ans;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0, 0, 1,-1};
    static int[] goal = new int[2];
    static boolean[][] visited;

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {goal[0], goal[1]});

        visited = new boolean[n][m];
        visited[goal[0]][goal[1]] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];

                if(nx<0||nx>=n||ny<0||ny>=m) continue;
                if(visited[nx][ny] || map[nx][ny] == 0) continue;

                ans[nx][ny] = ans[cur[0]][cur[1]]+1;
                q.add(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        ans = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j]= Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    goal[0] = i;
                    goal[1] = j;
                }
            }
        }

        bfs();

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j< m; j++) {
                if(!visited[i][j] && map[i][j] == 1) ans[i][j] = -1;
                sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
