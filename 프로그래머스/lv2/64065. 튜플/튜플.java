//14분(작은 배열부터 탐색 힌트..)
import java.util.*;
class Solution {
    public int[] solution(String s) {
        List<String> answerList = new ArrayList<>();
        List<String> repeatNums = new ArrayList<>();
        String[] ss = s.split("},");
        for(String num : ss) {
            num = num.replaceAll("[{ | }]" ,"");
            repeatNums.add(num);
        }
        
        repeatNums.sort((a, b) -> a.length()-b.length());
        
        for(String num : repeatNums) {
            String[] nums = num.split(",");
            for(String singleNum : nums) {
                if(!answerList.contains(singleNum)) {
                    answerList.add(singleNum);
                }
            }
        }
        
        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(answerList.get(i));
        }
        
        return answer;
    }
}