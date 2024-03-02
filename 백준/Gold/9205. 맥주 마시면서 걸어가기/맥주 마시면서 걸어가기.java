import java.util.*;
import java.io.*;

//맥주 한 박스에는 맥주 20개 들어있음
public class Main {
    static int n;
    static List<int[]> japyo = new ArrayList<>();

    public static boolean check() {
        boolean[][] isConnected = new boolean[n+2][n+2];

        for(int i = 0; i < n+2; i++) {
            for(int j = 0; j < n+2; j++) {
                int[] p1 = japyo.get(i);
                int[] p2 = japyo.get(j);

                int val = Math.abs(p1[0]-p2[0])+Math.abs(p1[1]-p2[1]);
                if(val <= 1000) isConnected[i][j] = isConnected[j][i] = true;
            }
        }

        for(int i = 0; i < n+2; i++) {
            for(int j = 0; j < n+2; j++) {
                for(int r = 0; r < n+2; r++) {
                    if(isConnected[j][i] && isConnected[i][r]) isConnected[j][r] = true;
                }
            }
        }

        return isConnected[0][n+1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine()); 

            japyo = new ArrayList<>();

            StringTokenizer st;
            for(int j = 0; j < n+2; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                japyo.add(new int[]{x, y});
            }
            
            if(check()) sb.append("happy\n");
            else sb.append("sad\n");
        }

        System.out.println(sb);
    }
}
