class Solution {
    public int solution(int n) {
        int[] dp = new int[n+1];
        int num = 1234567;
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i-2]%num+dp[i-1]%num;
        }
        return dp[n]%1234567;
    }
}