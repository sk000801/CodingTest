import java.util.*;
class Solution {
    Set<Integer> set = new HashSet<>();
    public boolean isPrime(int num) {
        if(num <= 1) return false;
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num%i==0) return false;
        }
        return true;
    }
    public  void dfs(int depth, String res, int n, boolean[] visited, String[] num) {
        if(depth == n) {
            int number = Integer.parseInt(res);
            if(isPrime(number)) set.add(number);
            return;
        }
        
        if(!res.equals("") && isPrime(Integer.parseInt(res))) set.add(Integer.parseInt(res));
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(depth+1, res+num[i], n, visited, num);
                visited[i] = false;
            }
        }
    }
    public int solution(String numbers) {
        String[] num = numbers.split("");
        boolean[] visited = new boolean[num.length];
        
        dfs(0, "", num.length, visited, num);

        return set.size();
    }
}