//10분
import java.util.*;
class Solution {
    String[] moeum = {"A", "E", "I", "O", "U"};
    List<String> answer = new ArrayList<>();
    public void dfs(int depth, String cur) {
        answer.add(cur);
        
        if(depth == 5) {
            return;
        }
        
        for(String s : moeum) {
            dfs(depth+1, cur+s);
        }
    }
    public int solution(String word) {
        int ans = 0;
        dfs(0, "");
        for(int i = 0; i < answer.size(); i++) {
            if(answer.get(i).equals(word)) {
                ans = i;
                break;
            }
        }
        return ans;
    }
}