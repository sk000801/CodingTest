import java.util.*;
import java.io.*;

public class Main {
    static int n, m, r;
    static int[][] map;
    static int[][] rotate;
    static int min = Integer.MAX_VALUE;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void move(int x, int y, int r, int[][] arr) {
        while(r > 0) {
            int[] start = new int[]{x-r-1, y-r-1};
            int[] fin = new int[]{x+r-1, y+r-1};
    
            int cur = arr[start[0]][start[1]];

            for(int i = start[0]+1; i <= fin[0]; i++) {
                arr[i-1][start[1]] = arr[i][start[1]];
            }

            for(int i = start[1]+1; i <= fin[1]; i++) {
                arr[fin[0]][i-1] = arr[fin[0]][i];
            }

            for(int i = fin[0]-1; i >= start[0]; i--) {
                arr[i+1][fin[1]] = arr[i][fin[1]];
            }

            for(int i = fin[1]-1; i > start[1]; i--) {
                arr[start[0]][i+1] = arr[start[0]][i];
            }

            arr[start[0]][start[1]+1] = cur; 

            r--;
        } 
    }

    public static void action(int[] cur) {
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = map[i][j];
            }
        }

        for(int i = 0; i < r; i++) {
            int[] change = rotate[cur[i]];

            move(change[0], change[1], change[2], arr);
        }

        min = Math.min(min, find(arr));
    }

    public static int find(int[][] arr) {
        int max = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            int value = 0;
            for(int j = 0; j < m; j++) {
                value += arr[i][j];
            }
            max = Math.min(max, value);
        }

        return max;
    }

    public static void perm(int depth, int[] cur, boolean[] visited) {
        if(depth == r) {
            action(cur);
            return;
        }

        for(int i = 0; i < r; i++) {
            if(!visited[i]) {
                visited[i] = true;
                cur[depth] = i;
                perm(depth+1, cur, visited);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        rotate = new int[r][3];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //(x-r, y-r) ~ (x+r, y+r) 까지 회전 (x, y) 기준으로 시계방향 회전
        for(int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            rotate[i] = new int[]{x, y, r};
        }

        int[] order = new int[r];
        boolean[] visited = new boolean[r];
        perm(0, order, visited);

        System.out.println(min);
    }
}
