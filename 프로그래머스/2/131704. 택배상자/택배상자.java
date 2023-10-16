// 너무 더러운 if/else와 친구들
// 스택에 있는 값과 순차적으로 증가하는 수 중 order 배열의 현재 인덱스 값과
// 일치하는 값을 찾으면 그게 answer, 일치하는 값이 없고 num이 order의 개수를 넘어가면
// 바로 while문 탈출
import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        int idx = 0;
        int num = 1;
        int len = order.length;
        
        while (idx < len) {
            if (!stack.isEmpty() && order[idx] == stack.peek()) {
                answer++;
                stack.pop();
                idx++;
            } else if (num == order[idx]) {
                idx++;
                num++;
                answer++;
            } 
            else if (num < len) {
                stack.push(num);
                num++;
            } else {
                break;
            }
        }

        return answer;
    }
}