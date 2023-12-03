import java.util.*;

//자두는 1,2의 위치에서 t초동안 떨어지고 w번만 움직이고 싶어 함
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        int w = in.nextInt();
        int[][] dp = new int[t+1][w+1];

        int cur = 1;
        int answer = 0;

        for(int i = 1; i <= t; i++) {
            int tree = in.nextInt();

            for(int j = 0; j <= w; j++) {
                if(j == 0) {
                    cur = 1;

                    if(tree == cur) dp[i][j] = dp[i-1][j]+1;
                    else dp[i][j] = dp[i-1][j];

                    continue;
                }

                if(j%2==0) {
                    cur = 1;
                } else {
                    cur = 2;
                }

                if(tree == cur) dp[i][j] = Math.max(dp[i-1][j]+1, dp[i-1][j-1]);
                else dp[i][j] = Math.max(dp[i-1][j-1]+1, dp[i-1][j]);

                answer = Math.max(dp[i][j], answer);
            }
        }

        System.out.println(answer);
    }
}