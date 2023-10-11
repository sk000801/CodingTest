// 내가 푼 게 아니라 stack 이라는 다른 분의 아이디어를 참조함....ㅠㅠ
import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        for(int i = 1; i < numbers.length; i++) {
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        
        return answer;
    }
}