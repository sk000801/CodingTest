import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] top = new int[n];

        Stack<int[]> stack = new Stack<>();

        StringBuffer sb = new StringBuffer();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {    
            top[i] = Integer.parseInt(st.nextToken());

            if(stack.isEmpty()) {
                sb.append("0 ");
                stack.push(new int[]{i+1, top[i]});
            } else {
                while(true) { 
                    if(stack.isEmpty()) {
                        sb.append("0 ");
                        stack.push(new int[]{i+1, top[i]});
                        break;
                    }

                    if(stack.peek()[1] > top[i]) { // 원하는 경우 (가장 가까운 탑이 나보다 높을 때)
                        sb.append(stack.peek()[0]).append(" ");
                        stack.push(new int[]{i+1, top[i]});
                        break;
                    } else { //그게 아니라면 가장 상단의 높이 pop
                        stack.pop();
                    }
                }
            }
        }

        System.out.println(sb);
    }
}