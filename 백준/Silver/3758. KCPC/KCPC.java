import java.io.*;
import java.util.*;

// 쫌 제발 직관적으로 생각하기 !!!!
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); //팀개수
            int k = Integer.parseInt(st.nextToken()); //문제개수
            int t = Integer.parseInt(st.nextToken()); //우리팀id
            int m = Integer.parseInt(st.nextToken());

            int[][] score = new int[n+1][k+1];
            int[] count = new int[n+1];
            int[] lastTime = new int[n+1];
            int[] total = new int[n+1];

            for(int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());

                int id = Integer.parseInt(st.nextToken()); //팀id
                int num = Integer.parseInt(st.nextToken()); //문제번호
                int s = Integer.parseInt(st.nextToken()); //점수

                score[id][num] = Math.max(score[id][num], s);
                count[id]++;
                lastTime[id] = j+1;
            }

            for(int x = 1; x <= n; x++) {
                for(int y = 1; y <= k; y++) {
                    total[x] += score[x][y];
                }  
            }

            int answer = 1;
            for(int x = 1; x <= n; x++) {
                if(x == t) continue;
                if(total[x] > total[t]) answer++;
                if(total[x] == total[t]) {
                    if(count[x] < count[t]) answer++;
                    else if(count[x] == count[t]) {
                        if(lastTime[x] < lastTime[t]) answer++;
                    }
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
