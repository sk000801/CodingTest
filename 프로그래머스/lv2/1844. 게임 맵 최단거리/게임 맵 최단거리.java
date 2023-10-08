//18분
import java.util.*;
class Solution {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int n, m;
    static boolean[][] visited;
    
    public int bfs(int x, int y, int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (!visited[nx][ny] && maps[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    maps[nx][ny] = maps[cur[0]][cur[1]] + 1;
                }

            }
        }
        
        if(visited[n-1][m-1]) {
            return maps[n-1][m-1];
        } else {
            return -1;
        }
    }
    
    public int solution(int[][] maps) {
       int answer = 0;

        n = maps.length;
        m = maps[0].length;

        visited = new boolean[n][m];
        
        return bfs(0, 0, maps);
    }
}