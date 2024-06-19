import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        
        int q = Integer.parseInt(br.readLine());

        int[][] arr = new int[s.length()+1][26];
        arr[1][s.charAt(0)-'a']++;

        for(int i = 2; i <= s.length(); i++) {
            int num = s.charAt(i-1)-'a';

            for(int j = 0; j < 26; j++) {
                int temp = arr[i-1][j];

                // 탐색 중인 문자가 같으면 + 1
                arr[i][j] = j == num ? temp+1 : temp;
            }
        }

        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            
            int temp = st.nextToken().charAt(0)-'a';
            int start = Integer.parseInt(st.nextToken())+1;
            int fin = Integer.parseInt(st.nextToken())+1;

            // fin 누적합 - start 누적합
            sb.append(arr[fin][temp]-arr[start-1][temp]).append("\n");
        }

        System.out.println(sb);
    }
}
