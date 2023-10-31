import java.util.*;
class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    List<Integer> answer = new ArrayList<>();
    boolean[][] visited;
    
    public void bfs(int x, int y, String[][] map) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new int[]{x, y});
        int res = 0;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            res += Integer.parseInt(map[cur[0]][cur[1]]);
            
            for(int i = 0; i < 4; i++) {
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                
                if(nx<0||nx>=map.length||ny<0||ny>=map[0].length) continue;
                if(!map[nx][ny].equals("X") && !visited[nx][ny]) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        
        if(res > 0) answer.add(res);
    }
    
    public int[] solution(String[] maps) {
        String[][] map = new String[maps.length][maps[0].length()];
        visited = new boolean[map.length][map[0].length];
        
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                map[i][j] = String.valueOf(maps[i].charAt(j));
            }    
        }
        
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j< map[0].length; j++) {
                if(!map[i][j].equals("X") & !visited[i][j]) {
                    bfs(i, j, map);
                }
            }
        }
        
        Collections.sort(answer);
        int[] ans = new int[answer.size()];
        if(ans.length == 0) return new int[]{-1};
        
        for(int i = 0; i < answer.size(); i++) {
            ans[i] = answer.get(i);
        }
        return ans;
    }
}