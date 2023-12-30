import java.util.*;

//한 자리 소수 2, 3, 5, 7
public class Main {
    static StringBuffer sb = new StringBuffer();

    public static boolean checkPrime(int num) {
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }

        return true;
    }

    public static void dfs(int firstNum, int N) {
        if(N == 0) {
            sb.append(firstNum).append("\n");
            return;
        }

        for(int i = 1; i < 10; i += 2) {
            int num = firstNum*10+i;
            if(checkPrime(num)) {
                dfs(num, N-1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int[] num = new int[]{2, 3, 5, 7};
        for(int i = 0; i < 4; i++) {
            dfs(num[i], N-1);
        }

        System.out.println(sb);
    }
}
