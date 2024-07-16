import java.io.*;
import java.util.*;

// 이건 다시 봐도 못 풀겠음 ㅠㅠ
public class Main {
    public static int cal(int dist, int[] japyo, int n) {
        int count = 1;

        int temp = japyo[0];
        for(int i = 1; i < n; i++) {
            if(temp+dist <= japyo[i]) {
                count++;
                temp = japyo[i];
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] japyo = new int[n];

        for(int i = 0; i < n; i++) {
            japyo[i] = Integer.parseInt(br.readLine());
        }   
        Arrays.sort(japyo);

        int start = 0;
        int fin = japyo[n-1]-japyo[0]+1;
        while(start < fin) { //start >= fin인 상태에서 while문이 끝남
            int mid = (start+fin)/2;
            if(cal(mid, japyo, n) < c) fin = mid;
            else start = mid+1;
        }

        System.out.println(start-1);
    }
}
