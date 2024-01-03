import java.util.*;

// 1. 올바른 괄호열인지 일단 판별
// 2. 올바른 괄호열 뭉쳐진 애들을 분리해서 calc에 넣어줌
// 3. 그리고 calc 값들을 더해줌
// 50분 동안 풀어봤다
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int value = 1;
        int answer = 0;

        String[] s = in.nextLine().split("");

        Stack<String> stack = new Stack<>();
        for(int i = 0; i < s.length; i++) {
            if(s[i].equals("(")) {
                stack.push(s[i]);
                value *= 2;
            } 
            if(s[i].equals("[")) {
                stack.push(s[i]);
                value *= 3;
            }
            if(s[i].equals(")")) {
                if(stack.isEmpty() || !stack.peek().equals("(")) {
                    answer = 0;
                    System.out.println(answer);
                    return;
                } 
                //근데 왜 이 조건이 붙는지 모르겠다
                //바로 닫히는 친구들만 값을 더해준다는 건가? () [] 같은
                else if(s[i-1].equals("(")) {
                    answer += value;
                }
                stack.pop();
                value /= 2;
            }
            if(s[i].equals("]")) {
                if(stack.isEmpty() || !stack.peek().equals("[")) {
                    answer = 0;
                    System.out.println(answer);
                    return;
                } else if(s[i-1].equals("[")) {
                    answer += value;
                }
                stack.pop();
                value /= 3;
            }
        }

        if(!stack.isEmpty()) {
            System.out.println(0);
            return;
        }
        System.out.println(answer);
    }
}   
