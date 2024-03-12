import java.util.*;
import java.io.*;

// 우리 병사는 "W", 남의 병사는 "B"
public class Main {
    static int n, m;
    static String[][] land;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static boolean[][] visited;

    public static int bfs(int x, int y, String flag) {
        int count = 1;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];

                if(nx<0||nx>=m||ny<0||ny>=n) continue;
                if(!visited[nx][ny] && land[nx][ny].equals(flag)) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        land = new String[m][n];
        visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            String[] s = br.readLine().split("");
            for(int j = 0; j < n; j++) {
                land[i][j] = s[j];
            }
        }

        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && land[i][j].equals("W")) {
                    visited[i][j] = true;
                    count1 += Math.pow(bfs(i, j, "W"), 2);
                }

                if(!visited[i][j] && land[i][j].equals("B")) {
                    visited[i][j] = true;
                    count2 += Math.pow(bfs(i, j, "B"), 2);
                }
            }
        }

        System.out.println(count1+" "+count2);
    }
}
