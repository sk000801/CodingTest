//10분
import java.util.*;
class Solution {
    Map<String, Integer> answer = new HashMap<>(); 
    public boolean isMatch(Map<String, Integer> map) {
        List<String> list = new ArrayList<>(map.keySet());
        List<String> list2 = new ArrayList<>(map.keySet());
        
        for(int i = 0; i < list.size(); i++) {
            if(!list2.contains(list.get(i))) return false;
            if(answer.get(list.get(i)) != map.get(list.get(i))) return false;
        }
        
        return true;
    }
    public int solution(String[] want, int[] number, String[] discount) {
        for(int i = 0; i < want.length; i++) {
            answer.put(want[i], number[i]);
        }
        
        int answer = 0;
        for(int i = 0; i+10 <= discount.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            for(int j = i; j < i+10; j++) {
                if(map.keySet().contains(discount[j])) {
                    map.put(discount[j], map.get(discount[j])+1);
                } else {
                    map.put(discount[j], 1);
                }
            }
            if(isMatch(map)) answer++;            
        }
        return answer;
    }
}