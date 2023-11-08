import java.util.*;
class Solution {
    int[] lever;
    int[] exit;
    int[] start;
    int[] dx = {-1,0,1,0};
    int[] dy = {0,-1,0,1};
    
    public int bfs(int[] start, int[] dest, String[][] map) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        q.add(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            if(cur[0] == dest[0] && cur[1] == dest[1]) return cur[2];
            
            for(int i = 0; i < 4; i++) {
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                
                if(nx<0||nx>=map.length||ny<0||ny>=map[0].length) continue;
                if(!map[nx][ny].equals("X") && !visited[nx][ny]) {
                    q.add(new int[]{nx, ny, cur[2]+1});
                    visited[nx][ny] = true;
                } 
            }
        }
        
        return -1;
    }
    
    public int solution(String[] maps) {
        String[][] board = new String[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[i].length(); j++) {
                board[i][j] = String.valueOf(maps[i].charAt(j));
                if(board[i][j].equals("L")) lever = new int[]{i, j};
                if(board[i][j].equals("E")) exit = new int[]{i, j};
                if(board[i][j].equals("S")) start = new int[]{i, j};
            }
        }
        
        int a = bfs(start, lever, board);
        if(a == -1) return -1;
        int b = bfs(lever, exit ,board);
        if(b == -1) return -1;
        
        return a+b;
    }
}