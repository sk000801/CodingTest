import java.io.*;
import java.util.*;

public class Main {
    static StringBuffer sb;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int idx = 1;

    public static class Area implements Comparable<Area> {
        int x, y, cost;

        public Area(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Area a) {
            return this.cost-a.cost;
        }
    }

    public static void bfs(int[][] arr) {
        int n = arr.length;

        PriorityQueue<Area> q = new PriorityQueue<>();
        q.add(new Area(0, 0, arr[0][0]));

        int[][] cost = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        cost[0][0] = arr[0][0];

        while(!q.isEmpty()) {
            Area cur = q.poll();

            if(cur.x == n-1 && cur.y == n-1) {
                sb.append("Problem ").append(idx++).append(": ").append(cur.cost).append("\n");
                return;
            }

            for(int i = 0; i < 4; i++) {
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];

                if(nx<0||ny<0||nx>=n||ny>=n) continue;
                if(cur.cost+arr[nx][ny] < cost[nx][ny]) {
                    cost[nx][ny] = cur.cost+arr[nx][ny];
                    q.add(new Area(nx, ny, cost[nx][ny]));
                } 
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuffer();
        StringTokenizer st;

        while (true) { 
            int n = Integer.parseInt(br.readLine());

            if(n == 0) break;

            int[][] arr = new int[n][n];

            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bfs(arr);
        }

        System.out.println(sb);
    }
}
