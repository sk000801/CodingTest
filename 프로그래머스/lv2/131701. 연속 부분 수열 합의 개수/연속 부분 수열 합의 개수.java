//6분
import java.util.*;
class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int[] arr = new int[elements.length*2];
        for(int i = 0; i < arr.length; i++) {
            if(i < elements.length) arr[i] = elements[i];
            else arr[i] = elements[i-elements.length];
        }
        
        for(int i = 1; i <= elements.length; i++) {
            for(int j = 0; j < elements.length; j++) {
                set.add(Arrays.stream(arr, j, j+i).sum());
            }
        }

        return set.size();
    }
}