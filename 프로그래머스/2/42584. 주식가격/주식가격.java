//스택, 큐로 안풀어도 풀 순 있긴 한데 이건 아닌 듯......
import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i = 0; i < prices.length-1; i++) {
            boolean all = true;
            for(int j = i+1; j < prices.length; j++) {
                if(prices[i] > prices[j]) {
                    answer[i] = j-i;
                    all = false;
                    break;
                }
            }
            if(all) answer[i] = prices.length-1-i;      
        }
        return answer;
    }
}