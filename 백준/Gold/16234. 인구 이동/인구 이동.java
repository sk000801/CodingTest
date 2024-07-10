import java.io.*;
import java.util.*;

public class Main {
    static int n, l, r;
    static int[][] map;
    static boolean[][] visited;
    static boolean check = false;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    public static void bfs(int[] land) {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        int hap = 0;
        
        q.add(new int[]{land[0], land[1]});

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if(visited[cur[0]][cur[1]]) continue;

            visited[cur[0]][cur[1]] = true;
            hap += map[cur[0]][cur[1]];
            list.add(new int[]{cur[0], cur[1]});

            for(int i = 0; i < 4; i++) {
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];

                if(nx<0||nx>=n||ny<0||ny>=n||visited[nx][ny]) continue;
                int diff = Math.abs(map[nx][ny]-map[cur[0]][cur[1]]);
                if(diff >= l && diff <= r) {
                    q.add(new int[]{nx, ny});
                }
            }
        }

        if(list.size() <= 1) return;

        int value = hap/list.size();

        for(int i = 0; i < list.size(); i++) {
            int[] temp = list.get(i);

            map[temp[0]][temp[1]] = value;
        }

        check = true;
    }  

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }   
        }

        int answer = 0;
        while(true) {
            visited = new boolean[n][n];
            check = false;

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(!visited[i][j]) bfs(new int[]{i, j});
                }
            }

            if(!check) break;

            answer++;
        }   

        System.out.println(answer);
    }
}
