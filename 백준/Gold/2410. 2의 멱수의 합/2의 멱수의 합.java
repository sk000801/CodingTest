import java.util.*;

// 이런 수학적인 사실은 도대체 어떻게 알 수 있는 것,,,
// 2의 거듭제곱으로 표현되는 자연수 (1도 ok)
// 이전 숫자 경우의수 + 2로 나눈 숫자의 경우의수
// 2 = 1+1, 2
// 3 = 1+1+1, 1+2
// 4 = 1+1+1+1, 2+2, 4, 2+1+1
// 5 = 1*5, 1+2*2, 1+4, 1+1+1+2
public class Main {
    public static void main(String[] args) {
        long[] dp = new long[1_000_001];
        dp[0] = dp[1] = 1;

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        for(int i = 2; i <= 1_000_000; i++) {
            dp[i] = (dp[i-2]+dp[i/2]) % 1_000_000_000;
        }

        System.out.println(dp[n]);
    }
}
