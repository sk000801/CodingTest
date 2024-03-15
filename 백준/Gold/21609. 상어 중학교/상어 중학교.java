import java.util.*;
import java.io.*;

// m은 색상의 개수
// 블록 = 검은색(-1), 무지개색(0), 일반 블록색
// 그룹 = 검은색 X, 일반 블록색 모두 same, 무지개 있든 없는 상관X
// 기준 블록은 검은색 블록 중 행/열이 가장 작은 블록

// 1. 크기가 가장 큰 블록 그룹 찾기
// -> 크기가 같다면 무지개 블록 수가 가장 많은 블록
// -> 기준 블록의 행/열이 가장 큰 것
// 2. 해당 그룹의 모든 블록 제거 -> 개수^2만큼 값 획득
// 3. 격자에 중력 작용 (검은색 제외 블록이 행의 번호가 큰 칸으로 이동)
// 4. 격자가 반시계 방향으로 회전
// 5. 다시 중력 작용
public class Main {
    static int n, m;
    static int[][] map;
    static List<Group> groups = new ArrayList<>();
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int result = 0;

    public static class Group {
        List<int[]> list = new ArrayList<>();
        int rainbowNum;
        int[] standard;

        Group(List<int[]> list, int rainbowNum, int[] standard) {
            this.list = list;
            this.rainbowNum = rainbowNum;
            this.standard = standard;
        }
    }

    public static void bfs(int x,int y, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        List<int[]> rainbow = new ArrayList<>();
        int rainbowNum = 0;

        int color = map[x][y];

        q.add(new int[]{x, y});
        list.add(new int[]{x, y});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];

                if(nx<0||nx>=n||ny<0||ny>=n) continue;
                if(!visited[nx][ny] && (map[nx][ny] == color || map[nx][ny] == 0)) {
                    visited[nx][ny] = true;
                    if(map[nx][ny] == 0) {
                        rainbowNum++;
                        rainbow.add(new int[]{nx, ny});
                    }
                    q.add(new int[]{nx, ny});
                    list.add(new int[]{nx, ny});
                }
            }
        }

        if(list.size() < 2) {
            for(int[] cur : list) {
                visited[cur[0]][cur[1]] = false;
            }
            return;
        }

        for(int[] cur : rainbow) {
            visited[cur[0]][cur[1]] = false;
        }

        Collections.sort(list, (a, b) -> {
            if(a[0] == b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });

        int[] standard = new int[2];
        for(int[] cur : list) {
            if(map[cur[0]][cur[1]] != 0) {
                standard[0] = cur[0];
                standard[1] = cur[1];
                break;
            }
        }

        groups.add(new Group(list, rainbowNum, standard));
    }

    public static void delete(List<int[]> list) {
        result += (int)Math.pow(list.size(), 2);

        for(int[] cur : list) {
            map[cur[0]][cur[1]] = -2;
        }
    }

    public static void gravity() {
        for(int i = n-2; i >= 0; i--) {
            for(int j = 0; j < n; j++) {
                int idx = i+1;
                if(map[i][j] >= 0) {
                    while(idx < n) {
                        if(map[idx][j] == -2) {
                            idx++;
                        } else break;
                    }

                    if(idx > i+1) {
                        map[idx-1][j] = map[i][j];
                        map[i][j] = -2;
                    }
                }                
            }
        }
    }

    public static void rotate() {
        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = map[j][n-1-i];
            }
        }

        map = arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
    
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {    
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && map[i][j] > 0) {
                    visited[i][j] = true;
                    bfs(i, j, visited);
                }
            }
        }

        while(groups.size() > 0) {
            Collections.sort(groups, (a, b) -> {
                if(a.list.size() == b.list.size()) {
                    if(a.rainbowNum == b.rainbowNum) {
                        if(a.standard[0] == b.standard[0]) {
                            return b.standard[1]-a.standard[1];
                        }
                        return b.standard[0]-a.standard[0];
                    }   
                    return b.rainbowNum-a.rainbowNum;
                } 
                return b.list.size()-a.list.size();
            });

            delete(groups.get(0).list);    
            gravity();
            rotate();
            gravity();

            groups = new ArrayList<>();
            visited = new boolean[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(!visited[i][j] && map[i][j] > 0) {
                        visited[i][j] = true;
                        bfs(i, j, visited);
                    }
                }
            }

            //System.out.println("중간합산: "+result);
        }


        System.out.println(result);
    }
}
