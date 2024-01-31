import java.util.*;

//공기청정기 설치 -> RxC인 격자판
//공기청정기는 항상 1번 열 설치, 두 행을 차지
//1초동안
//1. 미세먼지가 확산 (미세먼지가 있는 모든 칸에서 동시에)
// 상하좌우 모두로 확산
// but 공기청정기가 있거나 칸이 없으면 확산 X
// 확산되는 양은 그 칸의 값 / 5
//2. 공기청정기가 작동
// 위의 바람은 반시계 방향 순환, 아래는 시계방향 순환 

// 바람이 불면 미세먼지가 바람의 방향대로 한 칸씩 이동
// -> 어쨌든 공기정정기와 같은 x, y 값을 갖는 위치의 친구들이 영향을 받음
// 방에 남아있는 t초가 지난 뒤 , 미세먼지의 양 구해보자 

public class Main {
    static int r,c,t;
    static int[][] room;
    static int[][] dust;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static List<int[]> cleaner = new ArrayList<>();

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        int[] cur = q.poll();

        int dustValue = room[cur[0]][cur[1]]/5;

        for(int i = 0; i < 4; i++) {
            int nx = cur[0]+dx[i];
            int ny = cur[1]+dy[i];

            if(nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
            if(room[nx][ny] != -1) {
                dust[nx][ny] += dustValue;
                dust[cur[0]][cur[1]] -= dustValue;
                q.add(new int[]{nx, ny});
            }
        }
    }

    public static void moveUp() {
        int[] up = cleaner.get(0);

        for(int i = up[0]-1; i > 0; i--) {
            room[i][0] = room[i-1][0];
        }

        for(int i = 0; i < c-1; i++) {
            room[0][i] = room[0][i+1];
        }

        for(int i = 0; i < up[0]; i++) {
            room[i][c-1] = room[i+1][c-1];
        }

        for(int i = c-1; i > 1; i--) {
            room[up[0]][i] = room[up[0]][i-1];
        }

        room[up[0]][1] = 0;
    }

    public static void moveDown() {
        int[] down = cleaner.get(1);

        for(int i = down[0]+1; i < r-1; i++) {
            room[i][0] = room[i+1][0];
        }

        for(int i = 0; i < c-1; i++) {
            room[r-1][i] = room[r-1][i+1];
        }

        for(int i = r-1; i > down[0]; i--) {
            room[i][c-1] = room[i-1][c-1];
        }

        for(int i = c-1; i > 1; i--) {
            room[down[0]][i] = room[down[0]][i-1];
        }

        room[down[0]][1] = 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        r = in.nextInt();
        c = in.nextInt();
        t = in.nextInt();
        room = new int[r][c];

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                room[i][j] = in.nextInt();
                if(room[i][j] == -1) cleaner.add(new int[]{i, j});
            }
        }

        cleaner.sort((a, b) -> a[0]-b[0]);

        for(int tc = 0; tc < t; tc++) {
            dust = new int[r][c];

            for(int i = 0; i < r; i++) {
                for(int j = 0; j < c; j++) {
                    if(room[i][j] == -1) continue;
                    bfs(i, j);
                }
            }

            for(int i = 0; i < r; i++) {
                for(int j = 0; j < c; j++) {
                    room[i][j] += dust[i][j];
                }
            }

            moveUp();
            moveDown();
        }

        int sum = 0;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                sum += room[i][j];
            }
        }

        System.out.println(sum+2);
    }
}
