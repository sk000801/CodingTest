import java.util.*;
import java.io.*;

// 비바라기 -> (n, 1-2) (n-1, 1-2)에 비구름이 생김

// n*n 격자에서 연습 (1, 1) ~ (n, n)
// 모든 구름이 d 방향으로 s칸 이동
// 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물 양 1 증가
// 구름이 모두 사라짐
// 증가한 칸에 물복사버그 마법 시전 !
// -> 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니의 수만큼 (r, c) 바구니 물 증가
// 바구니에 저장된 물 2 이상인 모든 칸에 구름 생김 + 물의 양 2 줄어듦
// m번 이동 후 물의 양의 합

public class Main {
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[][] map;

    static class Cloud {
        int x; int y;

        public Cloud(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        List<Cloud> clouds = new ArrayList<>();
        clouds.add(new Cloud(n-1, 0));
        clouds.add(new Cloud(n-1, 1));
        clouds.add(new Cloud(n-2, 0));
        clouds.add(new Cloud(n-2, 1));

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {   
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());

            for(int j = 0; j < clouds.size(); j++) {
                Cloud cur = clouds.get(j);
                cur.x = (n+cur.x+dx[d]*(s%n))%n;
                cur.y = (n+cur.y+dy[d]*(s%n))%n;
                map[cur.x][cur.y]++;
            }

            boolean[][] visited = new boolean[n][n];
            for(int j = 0; j < clouds.size(); j++) {
                Cloud cur = clouds.get(j);
                int count = 0;

                visited[cur.x][cur.y] = true;
                for(int r = 1; r <= 7; r += 2) { //대각선 방향
                    int nx = cur.x+dx[r];
                    int ny = cur.y+dy[r];

                    if(nx >= 0 && ny >= 0 && nx <= n-1 && ny <= n-1) {
                        if(map[nx][ny] >= 1) count++;
                    }
                }
                map[cur.x][cur.y] += count;
            }
            clouds.clear();

            for(int x = 0; x < n; x++) {
                for(int y = 0; y < n; y++) {
                    if(!visited[x][y] && map[x][y] >= 2) {
                        map[x][y] -= 2;
                        clouds.add(new Cloud(x, y));
                    }
                }
            }
        }

        int answer = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] > 0) {
                    answer += map[i][j];
                }
            }
        }

        System.out.println(answer);
    }
}
