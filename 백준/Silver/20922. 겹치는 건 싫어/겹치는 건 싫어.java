import java.util.*;
import java.io.*;

//map 쓰고 싶어서 map 썼는데 자꾸 에러 난다 (getOrDefault 처리 했는디)
//그리고 배열 처리 했는데 시간초과 도대체 왜 나는거니;;
//설마 스캐너 땜시롱?
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];
        int[] count = new int[100_001];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int max = 0;
        while(end < n) {
            while(end < n && count[nums[end]]+1 <= k) {
                count[nums[end]]++;
                end++;
            }

            max = Math.max(max, end-start);
            count[nums[start]]--;
            start++;
        }

        System.out.println(max);
    }
}
