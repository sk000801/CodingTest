import java.util.*;

public class Main {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    public static class Node implements Comparable<Node> {
        int x;
        int y;
        int value;

        public Node(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public int compareTo(Node n) {
            return this.value-n.value;
        }
    }

    public static int bfs(int[][] road) {
        int n = road.length;
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(0, 0, road[0][0]));

        int[][] map = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(map[i], Integer.MAX_VALUE);
        }
        map[0][0] = road[0][0];

        while(!q.isEmpty()) {
            Node cur = q.poll();

            if(cur.x == n-1 && cur.y == n-1) {
                return cur.value;
            }

            for(int i = 0; i < 4; i++) {
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];

                if(nx<0||ny<0||nx>=n||ny>=n) continue;
                if(cur.value+road[nx][ny] < map[nx][ny]) {
                    map[nx][ny] = cur.value+road[nx][ny];
                    q.add(new Node(nx, ny, cur.value+road[nx][ny]));
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int idx = 1;
        while(in.hasNextInt()) {
            int n = in.nextInt();
            if(n == 0) break;
            int[][] road = new int[n][n];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    road[i][j] = in.nextInt();
                }
            }

            System.out.println("Problem "+idx+": "+bfs(road));
            idx++;
        }

    }
}
