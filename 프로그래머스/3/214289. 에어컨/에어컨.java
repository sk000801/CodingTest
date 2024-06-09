import java.util.*;

// 이거시 dp일줄이야 풀이를 참고함
// t1과 t2의 범위가 음수값도 포함이므로 그냥 값을 더해버림
class Solution {
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        int answer = 0;
        
        int[][] dp = new int[onboard.length][51];
        
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                dp[i][j] = 12345678;
            }
        }
        
        t1 += 10;
        t2 += 10;
        temperature += 10;
        
        dp[0][temperature] = 0;
        
        int diff = 1;
        if(temperature > t2) diff = -1;
        
        for(int i = 1; i < onboard.length; i++) {
            for(int j = 0; j <= 50; j++) {
                if((onboard[i] == 1 && t1 <= j && t2 >= j) || onboard[i] == 0) {
                    
                    if(0 <= j+diff && j+diff <= 50) dp[i][j] = Math.min(dp[i][j], dp[i-1][j+diff]);
                    
                    if(j == temperature) dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);
                    
                    if(0 <= j-diff && j-diff <= 50) dp[i][j] = Math.min(dp[i][j], dp[i-1][j-diff]+a);
                    
                    if(t1 <= j && t2 >= j) dp[i][j] = Math.min(dp[i][j], dp[i-1][j]+b);
                }
            }
        }
        
        answer = dp[onboard.length-1][0];
        for(int i = 1; i <= 50; i++) {
            answer = Math.min(answer, dp[onboard.length-1][i]);
        }
        
        return answer;
    }
}