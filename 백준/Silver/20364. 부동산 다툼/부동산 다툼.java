import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] ori = new int[q];
        for(int i = 0; i < q; i++) {
            ori[i] = Integer.parseInt(br.readLine());
        }

        boolean[] visited = new boolean[n+1];
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < q; i++) {
            int num = ori[i];
            int value = 0;

            while (true) { 
                if(num == 1) break;

                if(visited[num]) {
                    value = num;
                }

                num /= 2;
            }

            if(value == 0) visited[ori[i]] = true;
            
            sb.append(value).append("\n");
        }

        System.out.println(sb);
    }
}
