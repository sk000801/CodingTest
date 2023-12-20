import java.util.*;

class Solution {
    int n, m;
    Map<Integer, Integer> landNum = new HashMap<>();
    
    int[] dx = {-1,0,1,0};
    int[] dy = {0,-1,0,1};
    
    public void bfs(int x, int y, int[][] land, boolean[][] visited, int value) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        
        land[x][y] = value;
        int count = 1;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                
                if(nx<0||nx>=n||ny<0||ny>=m) continue;
                if(!visited[nx][ny] && land[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    land[nx][ny] = value;
                    q.add(new int[]{nx, ny});
                    count++;
                }
            }
        }
        
        landNum.put(value, count);
    }
    
    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        boolean[][] visited = new boolean[n][m];
        int value = 2;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j] && land[i][j] == 1) {
                    bfs(i, j, land, visited, value);
                    value++;
                }
            }
        }
        
        int max = 0;
        for(int j = 0; j < m; j++) {
            int count = 0;
            Set<Integer> set = new HashSet<>();
            for(int i = 0; i < n; i++) {
                if(land[i][j] > 1 && !set.contains(land[i][j])) {
                    count += landNum.get(land[i][j]);
                    set.add(land[i][j]);
                }
            }
            max = Math.max(max, count);
        }
        
        return max;
    }
}