import java.util.*;

//43분 헤매다가 풀이를 봄 처음에 단순 그리디로 접근하려다가 fail....
public class Main {
    static int n;
    static int[] attack = new int[]{9, 3, 1};
    static int[][] perm = {{-9,-3,-1},{-9,-1,-3},{-3,-9,-1},{-3,-1,-9},{-1,-9,-3},{-1,-3,-9}};
    static int[] xp;
    static int[][][] dp = new int[61][61][61];
    static int answer = Integer.MAX_VALUE;

    public static void dfs(int[] val, int count) {
        // 이미 해당 count가 최솟값을 넘었다면 경우의수를 셀 필요 없어짐
        if(answer <= count) return;

        if(dp[val[0]][val[1]][val[2]] != 0 && dp[val[0]][val[1]][val[2]] <= count) return;

        dp[val[0]][val[1]][val[2]] = count;

        // 재귀에서 최솟값을 0으로 맞춰 모두 제거되면 정답과 비교
        if(val[0] == 0 && val[1] == 0 && val[2] == 0) {
            answer = Math.min(answer, count);
            return;
        }

        for(int i = 0; i < 6; i++) {
            dfs(new int[]{Math.max(val[0]+perm[i][0], 0), Math.max(val[1]+perm[i][1], 0), Math.max(val[2]+perm[i][2], 0)}, count+1);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        xp = new int[3];
        for(int i = 0; i < n; i++) {
            xp[i] = in.nextInt();
        }

        dfs(xp, 0);

        System.out.println(answer);
    }
}
