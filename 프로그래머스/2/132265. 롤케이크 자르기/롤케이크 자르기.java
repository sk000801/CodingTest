//15분.. 해시맵이 개꿀이다
import java.util.*;
class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> all = new HashMap<>();
        Set<Integer> cut = new HashSet<>();
        
        for(int i = 0; i < topping.length; i++) {
            if(all.containsKey(topping[i])) {
                all.put(topping[i], all.get(topping[i])+1);
            } else {
                all.put(topping[i], 1);
            }
        }
        
        int answer = 0;
        for(int i = 0; i < topping.length; i++) {
            cut.add(topping[i]);
            
            all.put(topping[i], all.get(topping[i])-1);
            if(all.get(topping[i]) == 0) all.remove(topping[i]);
            
            if(cut.size() == all.size()) answer++;
        }
        
        return answer;
    }
}