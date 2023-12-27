import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();    
        Integer[] limit = new Integer[n];
        for(int i = 0; i < n; i++) {
            limit[i] = in.nextInt();
        }

        int m = in.nextInt();
        List<Integer> weight = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            weight.add(in.nextInt());
        }

        Arrays.sort(limit, Collections.reverseOrder());
        Collections.sort(weight, Collections.reverseOrder());

        if(limit[0] < weight.get(0)) {
            System.out.println(-1);
            return;
        }

        int time = 0;
        while(!weight.isEmpty()) {
            int idx = 0;
            for(int i = 0; i < limit.length;) {
                if(idx >= weight.size()) {
                    break;
                } else if(limit[i] >= weight.get(idx)) {
                    weight.remove(idx);
                    i++;
                } else idx++;
            }
            time++;
        }

        System.out.println(time);
    }
}
