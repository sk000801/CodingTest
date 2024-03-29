import java.util.*;
import java.io.*;

// 문제 예시가 map[4][5]
// 처음엔 아예 r번을 돌리려구 했는데, r번동안 n*m만큼 회전하면 시간 초과가 발생한다
// 방법을 찾아야 함!!
// https://howudong.tistory.com/193 이렇게 풀어보는게 이해에는 더 좋겠다
public class Main {
    static int n, m, r;
    static int[][] map;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void rotate(int start, int length) {
        for(int i = 0; i < length; i++) {
            int x = start;
            int y = start;
            int cur = map[y][x];

            int dir = 0;
            while(dir < 4) {
                int nx = x+dx[dir];
                int ny = y+dy[dir];

                if(nx<start||ny<start||nx>=m-start||ny>=n-start) {
                    dir++;
                    continue;
                }

                map[y][x] = map[ny][nx];
                x = nx;
                y = ny;
            } 

            map[start+1][start] = cur;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j< m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2*n+2*m-4 바깥 테두리 개수 (4는 겹치는 꼭짓점 4개를 빼준 것)
        // 이후 테두리 변의 길이가 2씩 줄어들기 때문에 -2*i를 붙여줌
        // 어차피 계속 회전하다보면 원래 상태로 돌아오므로 나눗셈 연산으로 반복을 줄임
        for(int i = 0; i < Math.min(n, m)/2; i++) {
            rotate(i, r%(((n-2*i)+(m-2*i))*2-4));
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}
