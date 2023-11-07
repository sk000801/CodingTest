import java.util.*;
class Solution {
    int[] origin;
    int[] goal;
    int[] dx = {-1,0,1,0};
    int[] dy = {0,-1,0,1};
    
    public int bfs(String[][] map) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        q.add(new int[]{origin[0], origin[1], 0});
        visited[origin[0]][origin[1]] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            if(cur[0] == goal[0] && cur[1] == goal[1]) return cur[2];
            
            for(int i = 0; i < 4; i++) {
                int j = 0;
                while(true) {
                    j++;
                    int nx = cur[0]+dx[i]*j;
                    int ny = cur[1]+dy[i]*j;
                    
                    if(nx>=0&&nx<map.length&&ny>=0&&ny<map[0].length&&!map[nx][ny].equals("D")) {
                        continue;
                    } else {
                        if(!visited[nx-dx[i]][ny-dy[i]]) {
                            visited[nx-dx[i]][ny-dy[i]] = true;
                            q.add(new int[]{nx-dx[i], ny-dy[i], cur[2]+1});
                        }
                        break;
                    }
                }
            }
        }
        
        return -1;
    }
    
    public int solution(String[] board) {
        int answer = 0;
        String[][] map = new String[board.length][board[0].length()];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length(); j++) {
                map[i][j] = String.valueOf(board[i].charAt(j));
                if(map[i][j].equals("R")) origin = new int[]{i, j};
                if(map[i][j].equals("G")) goal = new int[]{i, j};
            }
        }

        return bfs(map);
    }
}