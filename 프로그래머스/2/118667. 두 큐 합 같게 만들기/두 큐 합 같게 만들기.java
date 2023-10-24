import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        
        long hap1 = 0;
        long hap2 = 0;
        
        for(int i = 0; i < queue1.length; i++) {
            q1.add((long)queue1[i]);
            q2.add((long)queue2[i]);
            
            hap1 += queue1[i];
            hap2 += queue2[i];
        }
        
        while(hap1 != hap2 ) {
            if(answer >= 600_000) break;
            
            if(hap1 > hap2) {
                long a = q1.poll();
                hap1 -= a;
                hap2 += a;
                q2.add(a);
            } else if(hap1 < hap2) {
                long b = q2.poll();
                hap1 += b;
                hap2 -= b;
                q1.add(b);
            }
            
            answer++;
        }
        
        return answer >= 600_000 ? -1 : answer;
    }
}