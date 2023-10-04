// [최소 필요 피로도, 소모 피로도]
//13분
class Solution {
    int max = Integer.MIN_VALUE;
    
    public int getMax(int[] value, int k, int[][] dungeons) {
        int num = 0;
        
        for(int i = 0; i < dungeons.length; i++) {
            if(k-dungeons[value[i]][1] < 0 || k < dungeons[value[i]][0]) return num;
            k -= dungeons[value[i]][1];
            num ++;
        }
        
        return num;
    } 
    
    public void dfs(int k, int[][] dungeons, int[] value, int depth, boolean[] visited) {
        if(depth == value.length) {
            max = Math.max(max, getMax(value, k, dungeons));
            return;
        }
        
        for(int i = 0; i < value.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                value[depth] = i;
                dfs(k, dungeons, value, depth+1, visited);
                visited[i] = false;
            }
           
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        int[] value = new int[dungeons.length];
        boolean[] visited = new boolean[dungeons.length];
        
        dfs(k, dungeons, value, 0, visited);
        
        return max;
    }
}