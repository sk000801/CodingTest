import java.util.*;

public class Main {
    static int n;
    static int[] cal;
    static double[] price;
    static double m;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        StringBuffer sb = new StringBuffer();

        while(true) {
            n = Integer.parseInt(in.next());
            m = Double.parseDouble(in.next());

            if(n == 0 && m == 0.00) break;

            cal = new int[n];
            price = new double[n];

            for(int i = 0; i < n; i++) {
                cal[i] = Integer.parseInt(in.next());
                price[i] = Double.parseDouble(in.next());
            }            

            int[] dp = new int[(int)(m*100+0.5)+1];
            for(int i = 0; i < n; i++) {
                int curPrice = (int) (price[i]*100+0.5);
                int value = (int) (m*100+0.5);
                for(int j = 1; j <= value; j++) {
                    if(curPrice <= j) {
                        dp[j] = Math.max(dp[j-curPrice]+cal[i], dp[j]);
                    }
                }
            }

            sb.append(dp[(int)(m*100+0.5)]).append("\n");
        }

        System.out.println(sb);
    }    
}
