import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int w = in.nextInt();
        int h = in.nextInt();

        // w, h, 방향, 방향 변경 여부
        int[][][][] dp = new int[w+1][h+1][2][2];

        // 시작점과 일직선에 있는 점들은 모두 초기값을 채워줘야함
        for(int i = 1; i <= w; i++) {
            dp[i][1][0][0] = 1;
        }

        for(int i = 1; i <= h; i++) {
            dp[1][i][1][0] = 1;
        }

        // 3번째 방향 0 = 오른쪽, 1 = 위쪽
        // 방향 꺾임 여부 0 = X , 1 = 꺾임
        for(int i = 2; i <= w; i++) {
            for(int j = 2; j <= h; j++) {
                // 위쪽으로 움직이면 y값에서 변화
                // 오른쪽으로 움직이면 x값에서 변화
                
                dp[i][j][1][0] = (dp[i][j-1][1][1]+dp[i][j-1][1][0]) % 100_000;
                // 방향이 꺾여야 하므로 방향과 꺾는 여부 모두 반대가 됨
                dp[i][j][1][1] = (dp[i][j-1][0][0]) % 100_000;
                // 방향이 꺾이든 안꺾이든 상관 없음
                dp[i][j][0][0] = (dp[i-1][j][0][0]+dp[i-1][j][0][1]) % 100_000;
                dp[i][j][0][1] = dp[i-1][j][1][0];
            }
        }

        int answer = (dp[w][h][0][0]+dp[w][h][0][1]+dp[w][h][1][0]+dp[w][h][1][1]) % 100_000;

        System.out.println(answer);
    }
}
