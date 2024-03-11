import java.util.*;
import java.io.*;

// 연두가 만들 수 있는 가장 큰 완전제곱수
// 그냥 백트래킹 생각했는데 배열 안에서 요리조리 움직여야 하므로 for문이 적절할듯
// d(등차??)만 구해서 최댓값을 찾자
public class Main {
    static int n, m;
    static int[][] arr;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(s[j]);

                double val = Math.sqrt(arr[i][j]);
                if(val - (int) val == 0.0) answer = arr[i][j];
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int x = -n; x < n; x++) {
                    for(int y = -m; y < m; y++) {
                        if(x == 0 && y == 0) continue;
                        
                        int a = i;
                        int b = j;
                        int cur = 0;

                        while(a >= 0 && a < n && b >= 0 && b < m) {
                            cur = cur*10+arr[a][b];

                            double val = Math.sqrt(cur);
                            if(val - (int) val == 0.0) answer = Math.max(answer, cur);
                        
                            a += x;
                            b += y;
                        }
                    }
                }
            }
        }

        System.out.println(answer == Integer.MIN_VALUE ? -1 : answer);
    }
}
