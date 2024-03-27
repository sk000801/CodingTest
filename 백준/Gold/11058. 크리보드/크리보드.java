import java.util.*;

// 아니 도대체 이걸 어떻게 떠올려요 ;;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        long[] dp = new long[101];

        for(int i = 1; i <= 6; i++) {
            dp[i] = i;
        }

        for(int i = 7; i <= n; i++) {
            for(int j = 3; j <= i; j++) {
                // 화면에 A 출력하는 경우
                long print = dp[i-j];
                // 화면 전체 선택 후 버퍼에 복사하는 경우 붙여넣기(3번)   
                long buffer = dp[i-j]; //복사
                long count = j-2; //붙여넣기
                
                // (원래화면+복사한값)과 최댓값을 비교
                dp[i] = Math.max(dp[i], print+(buffer*count));
            }
        }

        System.out.println(dp[n]);
    }
}
