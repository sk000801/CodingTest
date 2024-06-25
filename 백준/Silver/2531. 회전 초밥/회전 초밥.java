import java.io.*;
import java.util.*;

// 이분탐색? 어렵다ㅠㅠ
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //접시의 수
        int d = Integer.parseInt(st.nextToken()); //가짓수
        int k = Integer.parseInt(st.nextToken()); //접시의수
        int c = Integer.parseInt(st.nextToken()); //쿠폰번호

        int[] kind = new int[3001];
        kind[c] = 3001;
        
        int[] sushi = new int[n];
        int count = 1;

        for(int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < k; i++) {
            if(kind[sushi[i]] == 0) count++;
            kind[sushi[i]]++;
        }

        int max = count;

        for(int i = 0; i < n-1; i++) {
            int num = sushi[i];
            int last = sushi[(i+k)%n];

            if(--kind[num] == 0) count--;
            if(++kind[last] == 1) count++;

            max = Math.max(max, count);
        }

        System.out.println(max);
    }
}
