import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int s = in.nextInt();
        int[] num = new int[n+1];

        for(int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while(start <= n && end <= n) {
            if(sum < s) { //값이 작다면
                sum += num[end++];
            } else {
                min = Math.min(min, end-start);
                sum -= num[start++];
            }
        }

        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}
