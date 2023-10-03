//8분 
import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] finishDay = new int[progresses.length];
        for(int i = 0; i < finishDay.length; i++) {
            int left = (100-progresses[i])%speeds[i] == 0 ? (100-progresses[i])/speeds[i] : (100-progresses[i])/speeds[i]+1; 
            finishDay[i] = left;
            if(i >= 1 && finishDay[i] < finishDay[i-1]) finishDay[i] = finishDay[i-1];
        }
        
        Arrays.sort(finishDay);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < finishDay.length; i++) {
            if(map.keySet().contains(finishDay[i])) {
                map.put(finishDay[i], map.get(finishDay[i])+1);
            } else {
                map.put(finishDay[i], 1);
            }
        }
        
        List<Integer> key = new ArrayList<>(map.keySet());
        Collections.sort(key);
        List<Integer> values = new ArrayList<>(map.values());      
        int[] answer = new int[values.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = map.get(key.get(i));
        }
        return answer;
    }
}