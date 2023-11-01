import java.util.*;
class Solution {
    int[][] network;
    
    public int bfs(int n, int idx) {
        int count = 1;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        q.add(1);
        visited[1] = true;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int i = 1; i <= n; i++) {
                if(!visited[i]) {
                    if(network[cur][i] == 1) {
                        q.add(i);
                        count++;
                        visited[i] = true;
                    }
                }
            }
        }
        
        return Math.abs(2*count-n);
    }
    
    public int solution(int n, int[][] wires) {
        int len = wires.length;    
        int answer = Integer.MAX_VALUE;
        network = new int[n+1][n+1];
        
        for(int j = 0; j < len; j++) {
            int a = wires[j][0];
            int b = wires[j][1];
            network[a][b] = 1;
            network[b][a] = 1;
        }

        for(int i = 0; i < len; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            network[a][b] = 0;
            network[b][a] = 0;
            answer = Math.min(answer, bfs(n, i));
            network[a][b] = 1;
            network[b][a] = 1;
        }
        
        return answer;
    }
}