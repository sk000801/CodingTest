import java.util.*;
import java.io.*;

// 배열의 각 칸에 있는 수 = 얼음의 양
// 파이어스톰 시전 시 단계 L을 결정해야 함
// 격자를 2^L * 2^L 로 나눠줘야함 -> 시계방향으로 90도 회전
// 그리고 얼음이 있는 칸 >= 3개 인접하지 않으면 얼음양 1 줄임

// [출력]
// 남아있는 얼음 A[r][c]의 합
// 남아있는 얼음 중 가장 큰 덩어리가 차지하는 칸의 개수

public class Main {
    static int n, q;
    static int length;
    static int[][] land;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static boolean[][] check;

    public static int[][] move(int line) {
        int[][] change = new int[length][length];

        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length; j++) {
                change[i][j] = land[i][j];
            }
        }

        // 주어진 구간(i, j) 안에서(r, p) 90도씩 이동시킨다
        // 일단 90도라면 열과 행이 서로 교차됨
        // arr[i][j] = arr[전체길이-1-j][i]
        for(int i = 0; i < length; i += line) {
            for(int j = 0; j < length; j += line) {
                for(int r = 0; r < line; r++) {
                    for(int p = 0; p < line; p++) {
                        //하지만 r과 p가 섞인 부분이 잘 이해가 안간다.
                        change[i+r][j+p] = land[i+line-1-p][j+r];
                    }
                }
            }
        }

        return change;
    }

    public static void declineIce() {
        boolean[][] visited = new boolean[length][length];

        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length; j++) {
                if(land[i][j] == 0) continue;

                int count = 0;

                for(int r = 0; r < 4; r++) {
                    int nx = i+dx[r];
                    int ny = j+dy[r];

                    if(nx<0||nx>=length||ny<0||ny>=length) continue;
                    if(land[nx][ny] > 0) count++;
                }

                if(count < 3) visited[i][j] = true;
            }
        }

        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length; j++) {
                if(visited[i][j]) land[i][j]--;
            }
        }
    }

    public static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        int answer = 1;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];

                if(nx<0||nx>=length||ny<0||ny>=length) continue;
                if(!check[nx][ny] && land[nx][ny]>0) {
                    check[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        length = (int)Math.pow(2, n);
        land = new int[length][length];

        for(int i = 0; i < length; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < length; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < q; i++) {
            int l = Integer.parseInt(st.nextToken());
            int line = (int) Math.pow(2, l);
            land = move(line);
            declineIce();
        }

        check = new boolean[length][length];

        int count = 0;
        int max = 0;
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length; j++) {
                if(land[i][j] > 0) {
                    count += land[i][j];
                    if(!check[i][j]) {
                        check[i][j] = true;
                        max = Math.max(max, bfs(i, j));
                    }                    
                }
            }
        }
        
        System.out.println(count+"\n"+max);
    }
}
