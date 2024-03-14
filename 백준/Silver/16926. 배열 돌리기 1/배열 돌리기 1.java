import java.util.*;
import java.io.*;

// 크기 n*m인 배열 돌리기
// 반시계방향으로 돌리기 (바깥 줄부터 안쪽줄?까지)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int groupNum = Math.min(n, m)/2;

        // 하 우 상 좌
        for(int i = 0; i < r; i++) {
            int[][] change = new int[n][m];
            
            for(int j = 0; j < groupNum; j++) {
                //왼쪽
                for(int p = j; p < m-j-1; p++) {
                    change[j][p] = arr[j][p+1];
                }

                //위쪽
                for(int p = j; p < n-j-1; p++) {
                    change[p][m-j-1] = arr[p+1][m-j-1];
                }
                
                //오른쪽
                for(int p = m-j-1; p > j; p--) {
                    change[n-j-1][p] = arr[n-j-1][p-1];
                }

                //아래쪽
                for(int p = n-j-1; p > j; p--) {
                    change[p][j] = arr[p-1][j];
                }

                change[j+1][j] = arr[j][j];
            }

            arr = change;
        }

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            if(i < n-1) sb.append("\n");
        }

        System.out.println(sb);
    }
}
