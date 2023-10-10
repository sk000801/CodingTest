// fees 기본 분 / 기본 요금 / 단위 시간 분 / 단위 요금
//15분?
import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Integer> result = new HashMap<>();
        
        for(String s : records) {
            String[] info = s.split(" ");
            int carNum = Integer.parseInt(info[1]);
            String[] time = info[0].split(":");
            int realTime = Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);
            if(map.containsKey(carNum)) {
                List<Integer> list = map.get(carNum);
                list.add(realTime);
                map.put(carNum, list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(realTime);
                map.put(carNum, list);
            }
        }
        
        List<Integer> nums = new ArrayList<>(map.keySet());
        Collections.sort(nums);
        for(int i = 0; i < nums.size(); i++) {
            List<Integer> list = map.get(nums.get(i));
            int res = 0;
            for(int j = 0; j < list.size(); j++) {
                if(j%2==0) res -= list.get(j);
                else res += list.get(j);
            }
            if(list.size()%2 == 1) res += 60*23+59;
            
            if(res <= fees[0]) result.put(nums.get(i), fees[1]);
            else if((res-fees[0])%fees[2] == 0) result.put(nums.get(i),fees[1]+fees[3]*(res-fees[0])/fees[2]);
            else result.put(nums.get(i), fees[1]+fees[3]*((res-fees[0])/fees[2]+1));
        } 
        
        int[] answer = new int[nums.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = result.get(nums.get(i));
        }
        
        return answer;
    }
}