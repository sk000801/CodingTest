import java.util.*;

public class Main {
    static HashMap<Long, Long> dp = new HashMap<>();
    static long p, q;
    
    public static long cal(long num) {
        if(dp.containsKey(num)) return dp.get(num);

        long num1 = (long) Math.floor(num/p);
        long num2 = (long) Math.floor(num/q);

        dp.put(num, cal(num1)+cal(num2));

        return dp.get(num);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long n = in.nextLong();
        p = in.nextLong();
        q = in.nextLong();

        dp.put((long) 0, (long) 1);

        System.out.println(cal(n));
    }
}
