import java.util.*;

// 원래 (왼쪽)
//      2
//   10 7 1
// 5 55 y
//   10 7 1
//      2

// 아래로 이동
//   1  x  1
// 2 7  y  7  2
//   10 55 10  
//      5   

// 오른쪽 이동
//   2
// 1 7 10 
// x y  55 5
// 1 7 10
//   2

// 위로 이동
//     5
//  10 55 10 
//2  7  y  7  2
//   1  x  1

// 처음 알파를 55%로 고정하고 생각했는데 그러면 안되는듯

public class Main {
    static int n;
    static int[][] sand;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    static int[] dz = {1,1,2,2};

    static int[][] spreadX = {{-1,1,-2,-1,1,2,-1,1,0}, {-1,-1,0,0,0,0,1,1,2}, {1,-1,2,1,-1,-2,1,-1,0}, {1,1,0,0,0,0,-1,-1,-2}};
    static int[][] spreadY = {{1,1,0,0,0,0,-1,-1,-2}, {-1,1,-2,-1,1,2,-1,1,0}, {-1,-1,0,0,0,0,1,1,2}, {1,-1,2,1,-1,-2,1,-1,0}};
    static int[] spreadRatio = {1, 1, 2, 7, 7, 2, 10, 10, 5};

    static int spreadNum = 0;

    public static void calculate(int x, int y) {
        int curX = x;
        int curY = y;

        while(true) {
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < dz[i]; j++) {
                    int nx = curX+dx[i];
                    int ny = curY+dy[i];

                    if(nx<0||nx>=n||ny<0||ny>=n) return;

                    int curSand = sand[nx][ny];
                    sand[nx][ny] = 0;
                    int curSpread = 0;

                    for(int r = 0; r < 9; r++) {
                        int sandX = nx+spreadX[i][r];
                        int sandY = ny+spreadY[i][r];
                        int val = (curSand*spreadRatio[r])/100;

                        if(sandX < 0 || sandX >= n || sandY < 0 || sandY >= n) spreadNum += val;
                        else sand[sandX][sandY] += val;
                        curSpread += val;
                    }

                    int alphaX = nx+dx[i];
                    int alphaY = ny+dy[i];
                    int alphaVal = curSand-curSpread;
                    if(alphaX<0||alphaX>=n||alphaY<0||alphaY>=n) spreadNum += alphaVal;
                    else sand[alphaX][alphaY] += alphaVal;

                    curX = nx;
                    curY = ny;
                }
            }

            for(int i = 0; i < 4; i++) {
                dz[i] += 2;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        sand = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sand[i][j] = in.nextInt();
            }
        }

        int x = n/2;
        int y = n/2;
        calculate(x, y);

        System.out.println(spreadNum);
    }
}
