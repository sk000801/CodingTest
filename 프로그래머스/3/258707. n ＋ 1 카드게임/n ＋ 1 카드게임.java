import java.util.*;

// 기존의 카드를 최대로 이용해야 동전을 최소한 쓰면서 최대 라운드로 이동할 수 있다!
// 벨로그 풀이 따라친 수준 ㅠㅠ
class Solution {
    Set<Integer> ori, renew;
    public int solution(int coin, int[] cards) {
        int answer = 0;
        int n = cards.length;
        
        ori = new HashSet<>();
        renew = new HashSet<>();
        
        // ori 집합에는 차례대로 n/3개의 카드만 넣어놓음
        int idx = n/3;
        for(int i = 0; i < idx; i++) {
            ori.add(cards[i]);
        }
        
        int goal = n+1;
        while(true) {
            answer++;
            if(idx >= n) break;
            
            // 이후 renew 집합에는 n/3 인덱스 이후의 카드들만 차례대로 넣음
            renew.add(cards[idx]);
            renew.add(cards[idx+1]);
            
            idx += 2;
            
            boolean flag = false;
            
            // 내가 현재 갖고 있는 카드로 N+1을 만들 수 있음
            for(int num : ori) {
                if(ori.contains(goal-num)) {
                    ori.remove(num);
                    ori.remove(goal-num);
                    
                    flag = true;
                    
                    break;
                }
            }
            
            // 위의 경우 해결 X 
            if(!flag) {
                // 동전으로 카드 1장을 뽑아 해결 가능한지
                if(coin > 0) {
                    for(int num : ori) {
                        if(renew.contains(goal-num)) {
                            ori.remove(num);
                            renew.remove(goal-num);
                            coin--;
                            flag = true;
                            break;
                        }
                    }
                }
            }
            
            // 추가 카드 2개로 해결이 가능한지 확인
            if(!flag) {
                // 2개는 되어야 추가 카드로 해결할 수 있음
                if(coin > 1) {
                    // renew 배열 중 숫자 조합으로 N+1 가능한지 확인
                    for(int num : renew) {
                        if(renew.contains(goal-num)) {
                            renew.remove(num);
                            renew.remove(goal-num);
                            coin -= 2;
                            flag = true;
                            break;
                        }
                    }
                }
            }
            
            // 3개의 경우에서 모두 N+1을 만들 수 없다면
            if(!flag) break;
        }
        
        return answer;
    }
}