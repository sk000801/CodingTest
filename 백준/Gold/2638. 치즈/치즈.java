import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static List<int[]> cheese = new ArrayList<>();
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    public static boolean existCheese() {
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                if(map[i][j] == 1) return true;
            }
        }

        return false;
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;
        map[0][0] = 2;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];

                if(nx<0||nx>=map.length||ny<0||ny>=map[0].length) continue;
                if(visited[nx][ny] || map[nx][ny] == 1) continue;

                map[nx][ny] = 2;
                q.add(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
    }

    public static void melt() {
        for(int i = 0; i < cheese.size(); i++) {
            int[] cur = cheese.get(i);

            int count = 0;
            for(int j = 0; j < 4; j++) {
                int nx = cur[0]+dx[j];
                int ny = cur[1]+dy[j];

                if(map[nx][ny] == 2) count++;
            }

            if(count >= 2) {
                map[cur[0]][cur[1]] = 0;
                cheese.remove(i);
                i--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        map = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                map[i][j] = in.nextInt();
                if(map[i][j] == 1) cheese.add(new int[]{i, j});
            }
        }

        int answer = 0;
        while(existCheese()) {
            answer++;
            visited = new boolean[n][m];
            bfs();
            melt();
        }

        System.out.println(answer);
    }
}
