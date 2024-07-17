import java.io.*;
import java.util.*;

// 당연히 replaceAll은 안될줄 알았음..
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String burst = br.readLine();

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
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.toString().equals("") ? "FRULA" : sb.reverse().toString());
    }
}
