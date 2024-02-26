import java.util.*;

// 세로선 n개, 가로선 m개
// 각각의 세로선마다 가로선을 놓을 수 있는 개수 h개
// 완전 탐색으로 사다리를 0~3개 놓는 경우의 수를 고려한다
// -> i번 세로선의 결과가 i번이 나와야 함
// 여기서 원하는 조건을 만족하지 못하면 -1 출력!
// 어렵다
public class Main {
    static int n, m, h;
    static int[][] area;

    public static boolean check() {
        for(int i = 1; i <= n; i++) {
            int pos = i;
            int start = 1;

            while(start <= h) {
                if(area[start][pos] == 1) {
                    pos++;
                } else if(area[start][pos-1] == 1) {
                    pos--;
                } 

                start++;
            }

            if(i != pos) return false;
        }

        return true;
    }

    public static void perm(int x, int depth, int num) {
        if(depth == num) {
            if(check()) {
                System.out.println(num);
                System.exit(0); //이건 처음봤군
            }
            return;
        }

        for(int i = x; i <= h; i++) {
            for(int j = 1; j < n; j++) {
                if(area[i][j] == 1 || area[i][j-1] == 1 || area[i][j+1] == 1) continue;
                
                area[i][j] = 1;
                perm(i, depth+1, num);
                area[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();
        h = in.nextInt();
        area = new int[h+1][n+1];

        for(int i = 0; i < m; i++) {
            int x = in.nextInt();
            int y = in.nextInt();

            area[x][y] = 1;
        }

        for(int i = 0; i <= 3; i++) {
            perm(1, 0, i);
        }

        System.out.println(-1);
    }
}
