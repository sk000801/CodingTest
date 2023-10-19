class Solution {
    public int solution(int n) {
        int num = 1_000_000_007;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i-1]%num+dp[i-2]%num;
            dp[i] %= num;
        }

        return dp[n];
    }
}