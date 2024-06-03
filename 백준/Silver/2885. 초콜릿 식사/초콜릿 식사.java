import java.util.*;

// k개 초콜릿을 먹으려면 k 이상의 초콜릿이 필요함
// 초콜릿의 크기가 k보다 크다면 반으로 쪼개며 답을 구함
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int k = in.nextInt();

        int n = 1;

        while(n < k) {
            n *= 2;
        }

        System.out.print(n+" ");

        int answer = 0;
        while(k > 0) {
            if(k >= n) {
                k -= n;
            } else {
                n /= 2;
                answer++;
            }
        }

        System.out.print(answer);
    }
}
