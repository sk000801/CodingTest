import java.io.*;
import java.util.*;

// n개의 횡단보도, 연속한 k개의 신호등이 있도록 신호등을 수리
// 배열의 구간합 인덱스 값 = 수리해야하는 신호등의 개수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] nums = new int[n+1];

        for(int i = 0; i < b; i++) {
            int num = Integer.parseInt(br.readLine());
            nums[num] = 1;
        }

        int answer = Integer.MAX_VALUE;
        
        for(int i = 1; i <= k; i++) {
            nums[i] += nums[i-1];
        }

        answer = nums[k];

        //k개씩 계속 값을 도출하는 느낌
        for(int i = k+1; i <= n; i++) {
            nums[i] += nums[i-1];
            answer = Math.min(answer, nums[i]-nums[i-k]);
        }

        System.out.println(answer);
    }
}
