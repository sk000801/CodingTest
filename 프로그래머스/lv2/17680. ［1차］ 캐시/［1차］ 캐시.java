import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) return cities.length*5;
        int answer = 0;
        List<String> list = new ArrayList<>();
        for(String s : cities) {
            String ss = s.toLowerCase();
            if(list.contains(ss)) {
                answer += 1;
                list.remove(ss);
                list.add(ss);
            } else {
                if(list.size() == cacheSize) {
                    list.remove(0);
                } 
                list.add(ss);
                answer += 5;
            }
        }
        return answer;
    }
}