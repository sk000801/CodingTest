//34분 
//우오오오오 헷갈려
import java.util.*;
class Solution {
    public int[] solution(String msg) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(char c = 'A'; c <= 'Z'; c++) {
            map.put(String.valueOf(c), (int)c-64);
        }
        
        int idx = 0;
        while(idx < msg.length()) {
            String s = "";
            for(int i = idx; i < msg.length(); i++) {
                if(map.containsKey(s+msg.substring(idx, idx+1))) {
                    s += msg.substring(i, i+1);
                } else break;
                idx++;
            }
            
            list.add(s);
            if(idx < msg.length()) {
                map.put(s+msg.charAt(idx), map.size()+1);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = map.get(list.get(i));
        }
        return answer;
    }
}