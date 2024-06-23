import java.io.*;
import java.util.StringTokenizer;

// 1. 주식 하나를 산다
// 2. 원하는 만큼 가지고 있는 주식을 판다
// 3. 아무것도 안한다
// 날 별로 주식의 가격을 파악해 얻을 수 있는 최대 이익 찾기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();

        int tc = Integer.parseInt(br.readLine());
        for(int i = 0; i < tc; i++) {
            int day = Integer.parseInt(br.readLine());
            int[] cost = new int[day];

            long answer = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < day; j++) {
                cost[j] = Integer.parseInt(st.nextToken());
            }

            long max = cost[day-1];
            for(int j = day-2; j >= 0; j--) {
                if(cost[j] > max) max = cost[j];
                else answer += max-cost[j]; //판매
            }   

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
