import java.util.*;

// 풀이를 참고하고 말았지.... 
public class Main {
    static boolean[][] dp;
    static int n;
    static int[] nums;

    public static void action(int idx, int weight) {
        if(dp[idx][weight]) return;
        dp[idx][weight] = true;

        if(idx == n) return;

        action(idx+1, weight+nums[idx]); //해당 추를 추가하던가
        action(idx+1, weight); //추가하지 말던가
        action(idx+1, Math.abs(weight-nums[idx])); //추를 뺐을 때
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        StringBuffer sb = new StringBuffer();

        n = in.nextInt();

        // 무게의 최댓값은 개수*최대무게 = 500*30 = 15000
        dp = new boolean[31][15001];

        nums = new int[31];
        for(int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        action(0, 0);
        
        int weightNum = in.nextInt();
        for(int i = 0; i < weightNum; i++) {
            int curWeight = in.nextInt();
            if(curWeight > 15000) sb.append("N ");
            else sb.append(dp[n][curWeight] ? "Y " : "N ");
        }

        System.out.println(sb);
    }
}
