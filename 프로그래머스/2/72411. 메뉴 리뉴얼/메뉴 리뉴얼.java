// 최소 2개 이상, 2명 이상의 손님이 주문
// course에 담긴 수가 메뉴 개수

// 1. orders에 존재하는 모든 문자들 담기 하나의 List에?
// 2. 얘네 사이에서 orders[i]의 개수만큼 dfs로 뽑아내기
    // -> 여기서 해당되는 단품메뉴 다 있는지 확인하는 개수 세는 함수 만들기

// 정렬이 자꾸 안돼서 망..
// 정렬은 됐는데 시간 복잡도에서 야무지게 걸렸다

import java.util.*;
class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = new String(arr);
        }
        
        for (int i = 0; i < course.length; i++) {
            int courseSize = course[i];
            Map<String, Integer> map = new HashMap<>();
            
            for (int j = 0; j < orders.length; j++) {
                String order = orders[j];
                if (order.length() < courseSize) continue;
                combination(order, courseSize, "", 0, map);
            }
            
            if(map.size() > 0) {
                int max = Collections.max(map.values());
                if (max == 1) continue;
                List<String> keys = new ArrayList<>(map.keySet());
                for(int j = 0; j < map.size(); j++) {
                    if(map.get(keys.get(j)) == max) answer.add(keys.get(j));
                }
            }
            
        }
        
        Collections.sort(answer);
        return answer.toArray(new String[answer.size()]);
    }
    
    public void combination(String order, int courseSize, String current, int index, Map<String, Integer> map) {
        if (current.length() == courseSize) {
            map.merge(current, 1, Integer::sum);
            return;
        }
        
        for (int i = index; i < order.length(); i++) {
            String next = current + order.charAt(i);
            combination(order, courseSize, next, i + 1, map);
        }
    }
}