import java.util.*;

public class Main {
    static int n, k, p, x;
    static int[] num;
    static int[][] digit = new int[][]{
        {1, 1, 1, 1, 1, 1, 0},
        {0, 0, 0, 0, 1, 1, 0},
        {1, 0, 1, 1, 0, 1, 1},
        {1, 0, 0, 1, 1, 1, 1},
        {0, 1, 0, 0, 1, 1, 1},
        {1, 1, 0, 1, 1, 0, 1},
        {1, 1, 1, 1, 1, 0, 1},
        {1, 0, 0, 0, 1, 1, 0},
        {1, 1, 1, 1, 1, 1, 1},
        {1, 1, 0, 1, 1, 1, 1}
    };

    public static boolean reverse(int target) {
        int[] temp = new int[k];
        int ori = target;
        for(int i = k-1; i >= 0; i--) {
            temp[i] = ori%10;
            ori /= 10;
        }

        int count = 0;
        for(int i = 0; i < k; i++) {
            for(int j = 0; j < 7; j++) {
                if(digit[num[i]][j] != digit[temp[i]][j]) {
                    count++;
                    if(count > p) return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        k = in.nextInt();
        p = in.nextInt();
        x = in.nextInt();
        
        num = new int[k];
        int ori = x;
        for(int i = k-1; i >= 0; i--) {
            num[i] = ori%10;
            ori /= 10;
        }

        int answer = 0;

        for(int i = 1; i <= n; i++) {
            if(i == x) continue;
            if(reverse(i)) answer++;
        }

        System.out.println(answer);
    }
}
