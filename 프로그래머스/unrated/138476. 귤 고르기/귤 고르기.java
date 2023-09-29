import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < tangerine.length; i++) {
            if(map.keySet().contains(tangerine[i])) {
                map.put(tangerine[i], map.get(tangerine[i])+1);
            } else {
                map.put(tangerine[i], 1);
            }
        }
        
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
        
        for(int i = list.size()-1; i >= 0; i--) {
            if(k <= 0) break;
                k -= list.get(i);
                answer++;
        }
        
        return answer;
    }
}