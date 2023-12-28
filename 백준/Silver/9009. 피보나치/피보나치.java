import java.util.*;

//가장 가까운 fn값을 찾는 것부터 시작해야 할듯
public class Main {
   public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();

        int t = in.nextInt();

        List<Long> list = new ArrayList<>();
        list.add((long)0);
        list.add((long)1);
        list.add((long)1);
        while(true) {
            long a = list.get(list.size()-2);
            long b = list.get(list.size()-1);
            long c = a+b;

            if(c <= 1_000_000_000) list.add(c);
            else break;
        }

        for(int i = 0; i < t; i++) {
            long n = in.nextLong();

            List<Long> ans = new ArrayList<>();

            while(n>0) {
                long num = 0;
                
                for(int j = 0; j < list.size(); j++) {
                    if(list.get(j) <= n) {
                        num = list.get(j);
                    } else {
                        break;
                    }
                }

                ans.add(num);
                n -= num;
            }

            Collections.sort(ans);

            for(int j = 0; j < ans.size(); j++) {
                sb.append(ans.get(j)).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
   }
}
