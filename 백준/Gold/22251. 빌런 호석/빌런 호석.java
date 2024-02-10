import java.util.*;
import java.io.*;

// n층 k자리수(엘베층수) 최소1/최대p개 반전 x층에 멈춰있음
public class Main {
    static int[][] digit = {{1, 1, 0, 1, 1, 1, 1}, 
    {0, 1, 0, 0, 0, 0, 1}, 
    {1, 1, 1, 0, 1, 1, 0}, 
    {1, 1, 1, 0, 0, 1, 1}, 
    {0, 1, 1, 1, 0, 0, 1}, 
    {1, 0, 1, 1, 0, 1, 1}, 
    {1, 0, 1, 1, 1, 1, 1}, 
    {1, 1, 0, 0, 0, 0, 1}, 
    {1, 1, 1, 1, 1, 1, 1},
    {1, 1, 1, 1, 0, 1, 1}};
    
    public static boolean isChange(int target, int[] num, int k, int p) {
        int[] targetArr = new int[k];
        for(int i = 0; i < k; i++) {
            targetArr[i] = target % 10;
            target /= 10;
        }

        int count = 0;

        for(int i = 0; i < k; i++) {
            for(int j = 0; j < 7; j++) {
                if(digit[num[i]][j] != digit[targetArr[i]][j]) {
                    count++;
                }
                if(count > p) return false;
            }
        }

        return true;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int answer = 0;

        int[] num = new int[k];
        int originalX = x;
        for(int i = 0; i < k; i++) {
            num[i] = x%10;
            x /= 10;
        }

        for(int i = 1; i <= n; i++) {
            if(i == originalX) continue;
            if(isChange(i, num, k, p)) answer++;
        }

        System.out.println(answer);
    }
}
