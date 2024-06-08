import java.util.*;

class Solution {
    int[] dy = {1,0,0,-1};
    int[] dx = {0,1,-1,0};
    int answer = 0;
    String val;
    Queue<int[]> q = new LinkedList<>();
    boolean[][] visited;
    int n;
    
    public void dfs(String[][] board) {
        //while(!q.isEmpty()) {
            int[] cur = q.poll();
            visited[cur[0]][cur[1]] = true;
            
            for(int i = 0; i < 4; i++) {
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                
                if(nx<0||nx>=n||ny<0||ny>=n) continue;
                if(visited[nx][ny]) continue;
                if(board[nx][ny].equals(val)) {
                    q.add(new int[]{nx, ny});
                    answer++;
                }
            }
        //}
    }
    
    public int solution(String[][] board, int h, int w) {
        n = board.length;
        
        val = board[h][w];      
        visited = new boolean[n][n];
        
        q.add(new int[]{h, w});
        
        dfs(board);
        
        return answer;
    }
}