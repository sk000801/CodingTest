import java.util.*;
class Solution {
    static char[] val = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static Map<Character, Integer> map;
    static int answer;
    
    public static boolean isRight(int[] ans, String[] data) {
        for(int i =  0; i < data.length; i++) {
            int a = ans[map.get(data[i].charAt(0))];
            int b = ans[map.get(data[i].charAt(2))];
            int val = Character.getNumericValue(data[i].charAt(4))+1;
            
            if(data[i].charAt(3) == '=') {
                if(Math.abs(a-b) != val) return false;
            }
            if(data[i].charAt(3) == '>') {
                if(Math.abs(a-b) <= val) return false;
            }
            if(data[i].charAt(3) == '<') {
                if(Math.abs(a-b) >= val) return false;
            }
        }
        
        return true;
    }
    
    public static void dfs(int depth, boolean[] visited, int[] ans, String[] data) {
        if(depth == 8) {
            if(isRight(ans, data)) answer++;
            return;
        }
        
        for(int i = 0; i < 8; i++) {
            if(!visited[i]) {
                visited[i] = true;
                ans[depth] = i;
                dfs(depth+1, visited, ans, data);
                visited[i] = false;
            }
        }
    }
    
    public int solution(int n, String[] data) {
        boolean[] visited = new boolean[8];
        int[] ans = new int[8];
        
        map = new HashMap<>();
        answer = 0;
        
        for(int i = 0; i < 8; i++) {
            map.put(val[i], i);
        }
        
        dfs(0, visited, ans, data);
        
        return answer;
    }
}