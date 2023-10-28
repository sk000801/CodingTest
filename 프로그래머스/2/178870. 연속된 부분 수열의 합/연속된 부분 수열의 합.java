//비내림차순이 오름차순으로 정렬된거인듯
import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int start = 0;
        int fin = 0;
        int hap = sequence[0];
        List<int[]> list = new ArrayList<>();
        
        while(start <= fin) {
            if(hap < k) {
                fin++;
                if(fin >= sequence.length) break;
                hap += sequence[fin];
            }
            
            else if(hap > k) {
               hap -= sequence[start];
                start++;
            }
            
            else {
                list.add(new int[]{start, fin});
                hap -= sequence[start];
                start++;
            }
        }
        
        Collections.sort(list, (int[] a, int[] b) -> (a[1]-a[0])-(b[1]-b[0]));
        
        return list.get(0);
    }
}