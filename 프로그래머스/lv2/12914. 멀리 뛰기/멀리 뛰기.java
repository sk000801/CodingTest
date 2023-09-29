class Solution {
    public long solution(int n) {
        long num = 1234567;
        long[] dp = new long[n+1];
        if(n == 1) return 1;
        if(n == 2) return 2;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i-2]%num+dp[i-1]%num;
        }
        return dp[n]%num;
    }
}