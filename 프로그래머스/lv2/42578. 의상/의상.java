//수학적인 지식이 있으면 개꿀인 문제
//7분 30초
import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        List<Integer> num = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++) {
            if(map.keySet().contains(clothes[i][1])) {
                List<String> list = map.get(clothes[i][1]);
                list.add(clothes[i][0]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(clothes[i][0]);
                map.put(clothes[i][1], list);
            }
        }
        
        List<String> key = new ArrayList<>(map.keySet());
        for(String s : key) {
            num.add(map.get(s).size());
        }
        
        for(int i = 0; i < num.size(); i++) {
            answer *= (1+num.get(i));
        }
        return answer-1;
    }
}