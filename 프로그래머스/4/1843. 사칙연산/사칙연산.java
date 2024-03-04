import java.util.*;

// 최댓값을 찾는 경우에
// a+b -> 최대+최대
// a-b -> 최대-최소
// -(a+b) -> -(최소+최소)

// dp라고 알려줘도 어떻게 풀 지 감이 안잡히는 문제..;

class Solution {
    int[][][] dp;
    List<Integer> nums = new ArrayList<>();
    List<String> op = new ArrayList<>();
    
    public int cal(int flag, int start, int fin) {
        if(start == fin) {
            dp[flag][start][fin] = nums.get(start);
            return dp[flag][start][fin];
        }    
        
        if(dp[flag][start][fin] != Integer.MIN_VALUE && dp[flag][start][fin] != Integer.MAX_VALUE) {
            return dp[flag][start][fin];   
        }
        
        dp[flag][start][fin] = 0;
        
        int value = flag == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        
        if(flag == 0) { //최대만들기
            for(int i = start; i < fin; i++) {
                if(op.get(i).equals("-")) {
                    value = Math.max(value, cal(0, start, i)-cal(1, i+1, fin));
                } else {
                    value = Math.max(value, cal(0, start, i)+cal(0, i+1, fin));
                }
            }
            
        } else { //최소만들기
            for(int i = start; i < fin; i++) {
                if(op.get(i).equals("-")) {
                    value = Math.min(value, cal(1, start, i)-cal(0, i+1, fin));
                } else {
                    value = Math.min(value, cal(1, start, i)+cal(1, i+1, fin));
                }
            }
        }
        
        dp[flag][start][fin] = value;
        return dp[flag][start][fin];
    }
    
    public int solution(String arr[]) {
        dp = new int[2][arr.length][arr.length];
        int n = arr.length/2;
        
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                dp[0][i][j] = Integer.MIN_VALUE;
                dp[1][i][j] = Integer.MAX_VALUE;
            }
        }
        
        for(int i = 0; i < arr.length; i++) {
            if(!arr[i].equals("+") && !arr[i].equals("-")) {
                nums.add(Integer.parseInt(arr[i]));
            } else {
                op.add(arr[i]);
            }
        }
        
        return cal(0, 0, n);
    }
}