import java.util.*;
import java.io.*;

// dist 배열을 활용해 최솟값을 찾아가는 과정
public class Main {
    static int n;
    static int[][] room;
    static int[][] value;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    public static void dijkstra() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        value[0][0] = 0;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];

                if(nx<0||nx>=n||ny<0||ny>=n) continue;
                if(value[nx][ny] > value[cur[0]][cur[1]]) {
                    if(room[nx][ny] == 1) value[nx][ny] = value[cur[0]][cur[1]];
                    else value[nx][ny] = value[cur[0]][cur[1]]+1;

                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        room = new int[n][n];
        value = new int[n][n];

        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for(int j = 0; j < n; j++) {
                room[i][j] = Integer.parseInt(s[j]);
                value[i][j] = Integer.MAX_VALUE;
            }
        }

        dijkstra();
        System.out.println(value[n-1][n-1]);
    }
}
