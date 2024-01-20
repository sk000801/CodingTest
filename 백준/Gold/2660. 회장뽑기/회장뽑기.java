import java.util.*;

//1점 = 그냥 친구이면
//2점 = 그냥 친구 + 친구의 친구
//3점 = 그냥 친구 + 친구의 친구 + 친구의 친구의 친구
// 회장 = 회원들 중 점수가 가장 작은 사람
public class Main {
    static int n;
    static int[][] friends;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        friends = new int[n+1][n+1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i != j) friends[i][j] = 10000;
            }
        }

        while(true) {
            int a = in.nextInt();
            int b = in.nextInt();

            if(a == -1 && b == -1) break;

            friends[a][b] = friends[b][a] = 1;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int r = 1; r <= n; r++) {
                    if(i != j && j != r) {
                        if(friends[j][r] > friends[j][i]+friends[i][r]) {
                            friends[j][r] = friends[j][i]+friends[i][r];
                        }
                     }
                }
            }
        }

        int score = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> hubo = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            int temp = 0;
            for(int j = 1; j <= n; j++) {
                if(i != j) {
                    temp = Math.max(friends[i][j], temp);
                }
            }
            score = Math.min(score, temp);
            map.put(i, temp);
        }

        int count = 0;
        for(int i = 1; i <= n; i++) {
            if(map.get(i) == score) {
                count++;
                hubo.add(i);
            }
        }

        System.out.println(score+" "+count);
        for(int i = 0; i < hubo.size(); i++) {
            System.out.print(hubo.get(i)+" ");
        }
    }
}
