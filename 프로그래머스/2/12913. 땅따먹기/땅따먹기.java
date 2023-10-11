class Solution {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][4];
        int answer = 0;
    
        for(int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }
        
        for(int i = 1; i < land.length; i++) {
            for(int j = 0; j < 4; j++) {
                dp[i][j] = land[i][j];
                if(j == 0) dp[i][j] += Math.max(Math.max(dp[i-1][1], dp[i-1][2]), dp[i-1][3]);
                else if(j==1) dp[i][j] += Math.max(Math.max(dp[i-1][0], dp[i-1][2]), dp[i-1][3]);
                else if(j==2) dp[i][j] += Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][3]);
                else dp[i][j] += Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2]);
            }
        }
        
        for(int i = 0; i < 4; i++) {
            answer = Math.max(answer, dp[land.length-1][i]);
        }
        
        return answer;
    }
}