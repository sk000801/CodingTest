import java.util.*;
import java.io.*;

// 불이 퍼지는 경우를 먼저 생각해야 한다는 점은 알았는데
// 동시에 이동하는걸 순차적으로 bfs를 통해 해결해야 한다는 것이 신기햇다
// 그리고 기존의 큐에 담긴 개수만큼 while문 안의 동작이 이뤄지는 것에 주의!
public class Main {
    static int r, c;
    static char[][] map;
    static int answer = 0;
    static Queue<Point> jq = new LinkedList<>();
    static Queue<Point> fq = new LinkedList<>();
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    static class Point {
        int x, y;
    
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        r = Integer.parseInt(s[0]);
        c = Integer.parseInt(s[1]);
        map = new char[r][c];

        boolean[][] visited1 = new boolean[r][c];
        boolean[][] visited2 = new boolean[r][c];

        for(int i = 0; i < r; i++) {
            String ss = br.readLine();
            for(int j = 0; j < c; j++) {
                map[i][j] = ss.charAt(j);
                if(map[i][j] == 'F') fq.add(new Point(i, j));
                if(map[i][j] == 'J') jq.add(new Point(i, j));
            }
        }

        while(!jq.isEmpty()) {
            answer++;

            int size1 = fq.size();
            while(size1-- > 0) {
                Point cur = fq.poll();
                visited1[cur.x][cur.y] = true;

                for(int i = 0; i < 4; i++) {
                    int nx = cur.x+dx[i];
                    int ny = cur.y+dy[i];
    
                    if(nx<0||ny<0||nx>=r||ny>=c||visited1[nx][ny]) continue;
                    if(map[nx][ny] == '.' || map[nx][ny] == 'F') {
                        visited1[nx][ny] = true;
                        fq.add(new Point(nx, ny));
                        map[nx][ny] = 'F';
                    }
                }
            }

            int size2 = jq.size();
            while(size2-- > 0) {
                Point cur = jq.poll();
                visited2[cur.x][cur.y] = true;

                for(int i = 0; i < 4; i++) {
                    int nx = cur.x+dx[i];
                    int ny = cur.y+dy[i];
    
                    if(nx<0||ny<0||nx>=r||ny>=c) {
                        System.out.println(answer);
                        return;
                    }
                    if(!visited2[nx][ny] && map[nx][ny] == '.') {
                        visited2[nx][ny] = true;
                        jq.add(new Point(nx, ny));
                        map[nx][ny] = 'J';
                    }
                }                
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}
