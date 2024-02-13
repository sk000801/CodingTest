import java.io.*;
import java.util.*;

// 고층 빌딩 찾기
// 빌딩은 n개 
// 두 고층 빌딩이 서로 볼 수 있으려면 두 지붕을 잇는 선분이
// 다른 고층 빌딩을 지나거나 접하지 않아야 함 (오른쪽의 빌딩들만 고려)
// 풀이 참고.....
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] building = new int[n];
        int[] num = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            building[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n-1; i++) {
            //양옆 빌딩이니까 무조건 보임
            num[i]++;
            num[i+1]++;

            double gi = building[i+1]-building[i];

            for(int j = i+2; j < n; j++) {
                double gi2 = (building[j]-building[i])/(double)(j-i);
                if(gi2 > gi) { //기울기가 커지면 보임
                    gi = gi2;
                    num[i]++;
                    num[j]++;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            max = Math.max(num[i], max);
        }

        System.out.println(max);        
    }
}
