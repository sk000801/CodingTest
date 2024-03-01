import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] map;
    static int totalNum = 0;

    public static int cal(int x, int y, int n1, int n2) {
        boolean[][] isBoundary = new boolean[n][n];

        for(int i = 0; i <= n1; i++) {
            isBoundary[x+i][y-i] = true;
            isBoundary[x+n2+i][y+n2-i] = true;
        }

        for(int i = 0; i <= n2; i++) {
            isBoundary[x+i][y+i] = true;
            isBoundary[x+n1+i][y-n1+i] = true;
        }

        int[] peopleNum = new int[5];

        for(int i = 0; i < x+n1; i++) {
            for(int j = 0; j <= y; j++) {
                if(isBoundary[i][j]) break;
                peopleNum[0] += map[i][j];
            }
        }

        for(int i = 0; i <= x+n2; i++) {
            for(int j = n-1; j > y; j--) {
                if(isBoundary[i][j]) break;
                peopleNum[1] += map[i][j];
            }
        }

        for(int i = x+n1; i < n; i++) {
            for(int j = 0; j < y-n1+n2; j++) {
                if(isBoundary[i][j]) break;
                peopleNum[2] += map[i][j];
            }
        }

        for(int i = x+n2+1; i < n; i++) {
            for(int j = n-1; j >= y-n1+n2; j--) {
                if(isBoundary[i][j]) break;
                peopleNum[3] += map[i][j];
            }
        }

        peopleNum[4] = totalNum-(peopleNum[0]+peopleNum[1]+peopleNum[2]+peopleNum[3]);

        Arrays.sort(peopleNum);

        return peopleNum[4]-peopleNum[0];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        map = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                totalNum += map[i][j];
            }
        }

        int min = Integer.MAX_VALUE;
        for(int x = 0; x < n; x++) {
            for(int y = 0; y < n; y++) {
                for(int n1 = 1; n1 < n; n1++) {
                    for(int n2 = 1; n2 < n; n2++) {
                        if(x+n1+n2 >= n) continue;
                        if(y-n1 < 0 || y+n2 >= n) continue;

                        int val = cal(x, y, n1, n2);
                        min = Math.min(min, val);
                    }
                }
            }
        }

        System.out.println(min);
    }
}
