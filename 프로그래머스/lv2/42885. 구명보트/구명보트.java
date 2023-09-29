import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        List<Integer> list = new ArrayList<>();
        for(int x : people) list.add(x);
        Collections.sort(list);

        ArrayDeque<Integer> dq = new ArrayDeque<>(50001);
        for(int x : list) dq.add(x);

        int ans = 0;
        while(!dq.isEmpty()) {
            int weight = dq.pollLast();
            if(!dq.isEmpty() && weight + dq.peekFirst() <= limit) { dq.pollFirst(); }
            ans++;
        }

        return ans;
    }
}