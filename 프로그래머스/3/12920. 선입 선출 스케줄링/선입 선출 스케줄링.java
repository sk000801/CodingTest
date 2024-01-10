//이분탐색 -> 마지막 작업 수행 시간 찾기 위해!
//(우선순위 큐를 처음 생각했는데 효율성에서 걸림)
import java.util.*;
class Solution {
    public int solution(int n, int[] cores) {
        if(n <= cores.length) return n;
        
        int answer = 0;
        
        int min = 1;
        int max = cores[0]*n;
        
        int time = 0; //최소 시간
        int work = 0; //그때의 작업량
        
        while(min <= max) {
            int mid = (min+max)/2;
            
            int tempCount = cores.length; //사용된 코어 개수(작업량)
            for(int i = 0; i < cores.length; i++) {
                tempCount += mid/cores[i];
            }
            
            //더 적은 시간 내에 수행 가능한지
            if(tempCount < n) {
                min = mid+1;
            } else {
                max = mid-1;
                time = mid;
                work = tempCount;
            }
        }
        
        work -= n; //작업량 -> n만큼 갱신
        for(int i = cores.length-1; i >= 0; i--) {
            if(time%cores[i] == 0) {
                if(work == 0) {
                    answer = i+1;
                    return answer;
                }
                work--;
            }
        }
        
        return answer;
    }
}