import java.util.*;
class Solution {
    public boolean isRight(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            if(stack.isEmpty()) stack.push(s.charAt(i));
            else if(stack.peek() == '[' && s.charAt(i) == ']') stack.pop();
            else if(stack.peek() == '(' && s.charAt(i) == ')') stack.pop();
            else if(stack.peek() == '{' && s.charAt(i) == '}') stack.pop();
            else stack.push(s.charAt(i));
        }
        
        return stack.isEmpty();
    }
    public int solution(String s) {
        int answer = 0;
        
        if(s.length() == 1) return 0;
        
        for(int i = 0; i < s.length(); i++) {
            s = s.substring(1, s.length())+s.substring(0, 1); 
            if(isRight(s)) answer++;
        }
        
        return answer;
    }
}