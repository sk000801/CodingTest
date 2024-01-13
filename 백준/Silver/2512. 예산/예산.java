import java.util.*;

public class Main {
    static int[] money;
    static int budget;

    public static long check(int mid) {
        long sum = 0;

        for(int i = 0; i < money.length; i++) {
            if(money[i] > mid) sum += mid;
            else sum += money[i];
        }

        return sum;
    }

    public static int action(int start, int fin) {
        int answer = 0;
        
        while(start <= fin) {
            int mid = (start+fin)/2;

            long sum = check(mid);

            if(sum <= budget) {
                start = mid+1;
                answer = mid;
            } else {
                fin = mid-1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        money = new int[n];

        int entire = 0;
        for(int i = 0; i < n; i++) {
            money[i] = in.nextInt();
            entire += money[i];
        }
        Arrays.sort(money);

        budget = in.nextInt();

        if(entire <= budget) {
            System.out.println(money[money.length-1]);
            return;
        }

        System.out.println(action(0, money[money.length-1]));
    }
}
