import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        Stack<Character> stack = new Stack<>();

        int answer = 0;
        int value = 1;

        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                value *= 2;
                stack.push(s.charAt(i));
            } else if(s.charAt(i) == '[') {
                value *= 3;
                stack.push(s.charAt(i));
            } else if(s.charAt(i) == ')') {
                if(stack.isEmpty() || stack.peek() != '(') { //아예 안되는 경우로 간주
                    answer = 0;
                    break;
                } else if(s.charAt(i-1) == '(') answer += value;

                stack.pop();
                value /= 2;                
            } else if(s.charAt(i) == ']') {
                if(stack.isEmpty() || stack.peek() != '[') { //아예 안되는 경우로 간주
                    answer = 0;
                    break;
                } else if(s.charAt(i-1) == '[') answer += value;        
                
                stack.pop();
                value /= 3;
            }
        }

        if(!stack.isEmpty()) sb.append(0).append("\n");
        else sb.append(answer).append("\n");

        System.out.println(sb);
    }
}

