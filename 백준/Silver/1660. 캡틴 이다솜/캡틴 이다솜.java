import java.util.*;

// 1 3 6 10 15 21 28 -> 한 사면체에는 1, 4, 10, 20, 35, 56, 84개를 가지고 있을 것
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt(); // 최대 300_000만
        int[] dp = new int[300_001];
        Arrays.fill(dp, Integer.MAX_VALUE);

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        list2.add(1);
        list2.add(4);
        for(int i = 2;; i++) {
            int sum = 2*list1.get(i-1)-list1.get(i-2)+1;
            list1.add(sum);

            int sum2 = list1.get(i)+list2.get(i-1);
            if(sum2 > 300_000) break;
            list2.add(sum2);
        }

       dp[0] = 0;
       dp[1] = 1;
       for(int i = 2; i <= 300_000; i++) {
        for(int j = 0; j < list2.size(); j++) {
            if(i-list2.get(j) >= 0) {
                dp[i] = Math.min(dp[i], dp[i-list2.get(j)]+1);
                //현재 list2.get(j) 값이 하나의 면을 이룰 수 있으므로
                //1만 더해주면 됨
            }
        }
       }

        System.out.println(dp[n] == Integer.MAX_VALUE ? 0 : dp[n]);
    }
}
