import java.util.*;


//이해하는데 10분 풀이하는데 20분

//n개의 곡 연주 중
//시작 볼륨 s 
//최대 볼륨 m
//현재 볼륨 = p , i번 곡 -> p+v[i]~p-v[i]
//v[i] -> i번 곡을 연주하기 전에 바꿀 수 있는 볼륨
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int s = in.nextInt();
        int m = in.nextInt();
        //가능한 볼륨 차이 저장 배열
        int[] diff = new int[n+1];
        //n번째 볼륨 차이에서 현재 볼륨 크기 존재 여부 판별?
        int[][] dp = new int[n+1][m+1];

        int answer = -1;

        for(int i = 1; i <= n; i++) {
            diff[i] = in.nextInt();
        }

        dp[0][s] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                if(dp[i-1][j] == 1) {
                    if(j+diff[i] <= m) {
                        dp[i][j+diff[i]] = 1;
                    }
                    if(j-diff[i] >= 0) {
                        dp[i][j-diff[i]] = 1;
                    }
                }
            }
        }

        for(int i = 0; i <= m; i++) {
            if(dp[n][i] == 1) {
                answer = Math.max(answer, i);
            }
        }

        System.out.println(answer);
    }
}
