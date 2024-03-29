import java.util.*;
import java.io.*;

public class Main {
    static int n, m, r;
    static int[][] map;
    static int[] order;

    public static void one() {
        int[][] arr = new int[n][m];

        for(int i = 0; i < n/2; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = map[n-1-i][j];
                arr[n-1-i][j] = map[i][j];
            }
        }

        map = arr;
    }

    public static void two() {
        int[][] arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m/2; j++) {
                arr[i][j] = map[i][m-1-j];
                arr[i][m-1-j] = map[i][j];
            }
        }

        map = arr;
    }

    public static void three() {
        int[][] arr = new int[m][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[j][n-i-1] = map[i][j];
            }
        }

        int temp = m;
        m = n;
        n = temp;

        map = arr;
    }

    public static void four() {
        int[][] arr = new int[m][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[m-1-j][i] = map[i][j];
            }
        }

        int temp = m;
        m = n;
        n = temp;

        map = arr;
    }

    public static void five() {
        int[][] arr = new int[n][m];

        for(int i = 0; i < n/2; i++) {
            for(int j = 0; j < m/2; j++) {
                arr[i][j+m/2] = map[i][j];
                arr[i+n/2][j+m/2] = map[i][j+m/2];
                arr[i+n/2][j] = map[i+n/2][j+m/2];
                arr[i][j] = map[i+n/2][j];
            }
        }

        map = arr;
    }

    public static void six() {
        int[][] arr = new int[n][m];

        for(int i = 0; i < n/2; i++) {
            for(int j = 0; j < m/2; j++) {
                arr[i+n/2][j] = map[i][j];
                arr[i+n/2][j+m/2] = map[i+n/2][j];
                arr[i][j+m/2] = map[i+n/2][j+m/2];
                arr[i][j] = map[i][j+m/2];
            }
        }

        map = arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        order = new int[r];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < r; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < r; i++) {
            int num = order[i];

            switch(num) {
                case 1:
                    one();
                    break;
                case 2:
                    two();
                    break;
                case 3:
                    three();
                    break;
                case 4:
                    four();
                    break;
                case 5:
                    five();
                    break;
                case 6:
                    six();
                    break;
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                sb.append(map[i][j]+" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
