import java.util.*;
import java.io.*;

// 주사위 
//   2
// 4 1 3
//   5
//   6
// 주사위 이동 방향 동쪽
// 1 천장, 6 바닥

// 위로 굴려
// 1
// 4 5 3
// 6
// 2

// 왼쪽 굴려
//   2
// 1 3 6
//   5
//   4

// 오른쪽 굴려
//   2
// 6 4 1
//   5
//   3

// 주사위 아랫면의 정수 A와 주사위가 있는 칸 B를 비교해 이동방향 결정
// A > B 이면 dx, dy 다음 인덱스로
// A < B 이면 dx, dy 이전 인덱스로
// A = B 이면 dx, dy 동일 인덱스로

// (x, y)에 있는 정수가 B라면 동서남북으로 이동했을 때도 모두 정수 B가 있어야 함
// 각 자리의 점수 = 위의 B * C (이동할 수 있는 칸의 수)
public class Main {
    static int n, m, k;
    static int[][] map;
    static int score = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] dice = {{0,2,0}, {4,1,3}, {0,5,0}, {0,6,0}};
    static int x = 0; 
    static int y = 0; 
    static int d = 0;

    public static void move() {
        int nx = x + dx[d];
        int ny = y + dy[d];

        if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
            d = (d+2)%4; //방향 반대
        }

        if(d == 0) { //동 
            int temp = dice[1][2]; //위
            dice[1][2] = dice[1][1];
            dice[1][1] = dice[1][0];
            dice[1][0] = dice[3][1];
            dice[3][1] = temp;
        }

        if(d == 1) {// 남
            int temp = dice[3][1]; //
            dice[3][1] = dice[2][1];
            dice[2][1] = dice[1][1];
            dice[1][1] = dice[0][1];
            dice[0][1] = temp;
        }

        if(d == 2) {// 서
            int temp = dice[1][0];
            dice[1][0] = dice[1][1];
            dice[1][1] = dice[1][2];
            dice[1][2] = dice[3][1];
            dice[3][1] = temp;
        }

        if(d == 3) {// 북
            int temp = dice[0][1];
            dice[0][1] = dice[1][1];
            dice[1][1] = dice[2][1];
            dice[2][1] = dice[3][1];
            dice[3][1] = temp;
        }

        x += dx[d];
        y += dy[d];
    }

    public static void getScore() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        int num = map[x][y];
        int count = 1;
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];

                if(nx<0||ny<0||nx>=n||ny>=m) continue;
                if(!visited[nx][ny] && map[nx][ny] == num) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    count++;
                }
            }
        }

        score += count*num;
    }

    public static void changeDirection() {
        int diceNum = dice[3][1];
        int num = map[x][y];

        if(diceNum < num) d = (d+3)%4;
        else if(diceNum > num) d = (d+1)%4;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < k; i++) {
            move();
            getScore();
            changeDirection();
        } 
        
        System.out.println(score);
    }   
}
