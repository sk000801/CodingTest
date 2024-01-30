import java.util.*;

public class Main {
    static int[][] road;
    static boolean[][] visited;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    static int max = 0;

    public static int bfs(int x, int y) {
        int count = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            count++;

            for(int i = 0; i < 4; i++) {
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];

                if(nx <= 0 || ny <= 0 || nx >= road.length || ny >= road[0].length) continue;

                if(road[nx][ny] == -1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        return count;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        road = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];

        int k = in.nextInt();
        for(int i = 0; i < k; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            road[a][b] = -1;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(!visited[i][j] && road[i][j] == -1) {
                    max = Math.max(max, bfs(i, j));
                }
            }
        }

        System.out.println(max);
    }  
}
