import java.util.*;

//수빈이는 x-1, x+1, 2*x의 위치로 이동 가능
//parent배열과 스택이 필요할 줄은 몰랐는데..
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] dp = new int[100_001];
        int[] parent = new int[100_001];
        StringBuffer sb = new StringBuffer();

        int n = in.nextInt();
        int k = in.nextInt();

        Queue<Integer> q = new LinkedList<>();
        dp[n] = 1;
        q.add(n);

        while(!q.isEmpty()) {
            int cur = q.poll();

            if(cur+1 <= 100_000 && dp[cur+1] == 0) {
                dp[cur+1] = dp[cur]+1;
                q.add(cur+1);         
                parent[cur+1] = cur;      
            }

            if(cur-1 >= 0 && dp[cur-1] == 0) {
                dp[cur-1] = dp[cur]+1;
                q.add(cur-1);
                parent[cur-1] = cur;
            }

            if(cur*2 <= 100_000 && dp[cur*2] == 0) {
                dp[cur*2] = dp[cur]+1;
                q.add(cur*2);
                parent[cur*2] = cur;
            }

            if(cur == k) break;
        }

        Stack<Integer> stack = new Stack<>();
        stack.add(k);
        int value = k;
        while(value != n) {
            int next = parent[value];
            stack.push(next);
            value = next;
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(dp[k]-1);
        System.out.println(sb);
    }
}
