import java.util.*;

//역시 시간 초과가 문제였고,, 자료구조 카테고리를 생각해야 하고,,
//stack을 써야만 시간 초과를 막을 수 있는 듯
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        String burst = in.nextLine();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));

            if(stack.size() >= burst.length()) {
                boolean flag = true;
                for(int j = 0; j < burst.length(); j++) {
                    if(stack.get(stack.size()-burst.length()+j) != burst.charAt(j)) {
                        flag = false;
                        break;
                    }
                }

                if(flag) {
                    for(int j = 0; j < burst.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for(char c : stack) {
            sb.append(c);
        }

        System.out.println(sb.length() > 0 ? sb : "FRULA");
    }
}
