import java.io.*;
import java.util.*;

// 1. 나무 길이의 합이 3으로 나누어 떨어져야 함
// 2. 2와 1은 함께 가야 함 -> 길이를 입력받을 때 2를 뿌릴 수 있는 수 count
//    ** 2를 뿌릴 수 있는 수 = 2로 나눈 몫
// 3. count 값이 나무 길이의 합을 3으로 나눈 몫보다 크거나 같아야 함
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] trees = new int[n];
        int total = 0;
        int count = 0;

        for(int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());

            total += trees[i];
            count += trees[i]/2;
        }

        if(total % 3 != 0 || count < total/3) {
            System.out.println("NO");
            return;
        }

        System.out.println("YES");
    } 
}
