import java.util.*;
import java.io.*;

// 처음에 중복되는 캔디 수를 더해서 값이 너무 크게 나왔다;;
// 유니온 파인드로 그룹화 하는게 중요한듯
public class Main {
    static int n,m,k;
    static int[] candy;
    static int[] group;
    static int[] friends;

    public static int find(int a) {
        if(a == group[a]) return a;

        return group[a] = find(group[a]);
    }

    public static void grouping(int a, int b) {
        int x = find(a);
        int y = find(b);

        if(x < y) group[y] = x;
        else group[x] = y;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        group = new int[n+1];
        friends = new int[n+1];

        candy = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            candy[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(friends, 1);

        for(int i = 1; i <= n; i++) {
            group[i] = i;
        }

        // 한 아이의 사탕을 뺏어가면 그 아이의 친구들 사탕도 뺏어감
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            grouping(a, b);
        }

        for(int i = 1; i <= n; i++) {
            if(group[i] != i) {
                int num = find(i);

                candy[num] += candy[i];
                friends[num] += friends[i];
            }
        }

        List<int[]> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(group[i] == i) {
                list.add(new int[]{friends[i], candy[i]});
            }
        }
        

        int[][] dp = new int[list.size()+1][k];
        for(int i = 1; i < list.size()+1; i++) {
            int num = list.get(i-1)[0];
            int candies = list.get(i-1)[1];

            for(int j = 0; j < k; j++) {
                if(num <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-num]+candies);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[list.size()][k-1]);
    }
}
